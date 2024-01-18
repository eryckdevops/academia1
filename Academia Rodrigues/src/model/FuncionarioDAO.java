package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO extends DAO {
    private static FuncionarioDAO instance;
    private static Connection myCONN;

    private FuncionarioDAO() {
        
    }

    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            if(myCONN == null) {
                try {
                myCONN = instance.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return instance;
    }
    
    private Funcionario buildObject(ResultSet rs) {
        Funcionario funcionario = null;
        try { 
            funcionario = new Funcionario(rs.getInt("id_pessoa"), rs.getString("rg"), rs.getString("cpf"),
                rs.getString("nome"), rs.getString("sexo"), rs.getString("dt_nasc"), rs.getString("telefone"),
                rs.getString("celular"), rs.getString("email"), rs.getString("endereco"), rs.getString("cep"),
                rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("cartao"),
                rs.getString("dt_admissao"), rs.getBoolean("gerente"), rs.getString("senha"));
        } catch (SQLException e) {
        }
        return funcionario;
    }
   
    
    //CRUD
    //CADASTRO
    public boolean cadastrar(String rg, String cpf, String nome, String sexo, String dtNasc,
        String telefone, String celular, String email, String endereco, String cep, String estado,
        String cidade,String bairro, String dtAdmissao, boolean gerente, String senha, String cartao) {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareStatement("exec cadastrarFuncionarios ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            stmt.setString(1, rg);
            stmt.setString(2, cpf);
            stmt.setString(3, nome);
            stmt.setString(4, sexo);
            stmt.setString(5, dtNasc);
            stmt.setString(6, telefone);
            stmt.setString(7, celular);
            stmt.setString(8, email);
            stmt.setString(9, endereco);
            stmt.setString(10, cep);
            stmt.setString(11, estado);
            stmt.setString(12, cidade);
            stmt.setString(13, bairro);
            stmt.setString(17, cartao);
            stmt.setString(14, dtAdmissao);
            stmt.setBoolean(15, gerente);
            stmt.setString(16, senha);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    //RESTAURAR
    public List<Funcionario> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Funcionario> funcionarios = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                funcionarios.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            
        }
        return funcionarios;
    }

    public List<Funcionario> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM consultarFuncionarios");
    }

    public List<Funcionario> retrieveLike(String nome) {
        return this.retrieveGeneric("exec buscarFuncionarios '" + nome + "'");
    }

    //ATUALIZAR
    public boolean atualizar(Funcionario funcionario) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec atualizarFuncionarios ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getRg());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getNome());
            stmt.setString(5, funcionario.getSexo());
            stmt.setString(6, funcionario.getDtNasc());
            stmt.setString(7, funcionario.getTelefone());
            stmt.setString(8, funcionario.getCelular());
            stmt.setString(9, funcionario.getEmail());
            stmt.setString(10, funcionario.getEndereco());
            stmt.setString(11, funcionario.getCep());
            stmt.setString(12, funcionario.getEstado());
            stmt.setString(13, funcionario.getCidade());
            stmt.setString(14, funcionario.getBairro());
            stmt.setString(15, funcionario.getCartao());
            stmt.setString(16, funcionario.getDtAdmissao()); 
            stmt.setBoolean(17, funcionario.isGerente());
            stmt.setString(18, funcionario.getSenha());
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if (rowCount == 1) {
                return true;
            }
        } catch (SQLException ex) {
            
        }
        return false;
    }

    //REMOVER
    public boolean remover(int idFuncionario) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec deletarFuncionarios ?");
            stmt.setInt(1, idFuncionario);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount == 1)
                return true;
            } catch (SQLException ex) {
            
            }
        return false;
    }
}
