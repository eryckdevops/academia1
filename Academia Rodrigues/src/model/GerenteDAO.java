package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenteDAO extends DAO{
    private static GerenteDAO instance;
    private static Connection myCONN;

    private GerenteDAO() {

    }

    public static GerenteDAO getInstance() {
        if (instance == null) {
            instance = new GerenteDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(GerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    private Gerente buildObject(ResultSet rs) {
        Gerente gerente = null;
        try {
            gerente = new Gerente(rs.getInt("id_pessoa"), rs.getString("rg"), rs.getString("cpf"),
                rs.getString("nome"), rs.getString("sexo"), rs.getString("dt_nasc"), rs.getString("telefone"),
                rs.getString("celular"), rs.getString("email"), rs.getString("endereco"), rs.getString("cep"),
                rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("cartao"),
                rs.getString("dt_admissao"), rs.getBoolean("gerente"), rs.getString("senha"));
        } catch (SQLException e) {
        }
        return gerente;
    }

    
    //CRUD
    //CADASTRO
    public boolean cadastrar(int id, String rg, String cpf, String nome, String sexo, String dtNasc,
        String telefone, String celular, String email, String endereco, String cep, String estado,
        String cidade,String bairro, String dtAdmissao, String gerente, String senha, String cartao) {
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
            stmt.setString(15, gerente);
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
    public List<Gerente> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Gerente> gerentes = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                gerentes.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {

        }
        return gerentes;
    }

    public List<Gerente> retrieveAll() { //pessoasClientes = View
        return this.retrieveGeneric("SELECT * FROM buscaFuncionario ORDER BY nome");
    }

    public List<Gerente> retrieveAllOrderById() {
        return this.retrieveGeneric("SELECT * FROM buscaFuncionario WHERE gerente = 1 ORDER BY id_pessoa");
    }

    public List<Gerente> retrieveLike(String nome) {
        return this.retrieveGeneric("exec buscaFuncionario '" + nome + "'");
    }

    public Gerente retrieveById(int id) {
        Gerente gerente = null;
        List<Gerente> gerentes = this.retrieveGeneric("SELECT * FROM buscaFuncionario WHERE id_pessoa = " + id);
        if (!gerentes.isEmpty()) {
            gerente = gerentes.get(0);
        }
        return gerente;
    }

    //ATUALIZAR
    public boolean atualizar(Funcionario funcionario) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec editarFuncionario '?', '?', '?', '?', '?', '?', '?', '?', '?', '?',"
                    + " '?', '?', '?', '?', '?', '?', '?' WHERE id_pessoa = '?'");
            stmt.setString(1, funcionario.getRg());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getNome());
            stmt.setString(4, funcionario.getSexo());
            stmt.setString(5, funcionario.getDtNasc());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCelular());
            stmt.setString(8, funcionario.getEmail());
            stmt.setString(9, funcionario.getEndereco());
            stmt.setString(10, funcionario.getCep());
            stmt.setString(11, funcionario.getEstado());
            stmt.setString(12, funcionario.getCidade());
            stmt.setString(13, funcionario.getBairro());
            stmt.setString(14, funcionario.getDtAdmissao());
            stmt.setBoolean(15, funcionario.isGerente());
            stmt.setString(16, funcionario.getSenha());
            stmt.setString(17, funcionario.getCartao());

            int update = this.executarQuery(stmt);
            if (update == 1) {
                return true;
            }
            stmt.close();
        } catch (SQLException ex) {

        }
        return false;
    }

    //REMOVER
    public void remover(Funcionario funcionario) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec deletarFuncionario WHERE id_pessoa = '?'");
            stmt.setInt(1, funcionario.getId());
            this.executarQuery(stmt);
            stmt.close();
        } catch (SQLException ex) {

        }
    }
}
