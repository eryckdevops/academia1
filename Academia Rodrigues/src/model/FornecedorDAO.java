package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO extends DAO {
    private static FornecedorDAO instance;
    private static Connection myCONN;

    private FornecedorDAO() {
    }

    public static FornecedorDAO getInstance() {
        if (instance == null) {
            instance = new FornecedorDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private Fornecedor buildObject(ResultSet rs) {
        Fornecedor fornecedor = null;
        try { 
            fornecedor = new Fornecedor(rs.getInt("id_fornecedor"), rs.getString("nome"), rs.getString("cnpj"), 
                rs.getString("telefone"), rs.getString("celular"), rs.getString("email"), rs.getString("endereco"), 
                rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"));
        } catch (SQLException e) {
        }
        return fornecedor;
    }
   
    
    //CRUD
    //CADASTRO
    public boolean cadastrar(String nome, String cnpj, String telefone, String celular, String email, String endereco, 
            String cep, String estado, String cidade, String bairro) {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareStatement("exec cadastrarFornecedores ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            stmt.setString(1, nome);
            stmt.setString(2, cnpj);
            stmt.setString(3, telefone);
            stmt.setString(4, celular);
            stmt.setString(5, email);
            stmt.setString(6, endereco);
            stmt.setString(7, cep);
            stmt.setString(8, estado);
            stmt.setString(9, cidade);
            stmt.setString(10, bairro);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if (rowCount == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    //RESTAURAR
    public List<Fornecedor> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Fornecedor> fornecedores = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                fornecedores.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            
        }
        return fornecedores;
    }

    public List<Fornecedor> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM consultarFornecedores");
    }

    public List<Fornecedor> retrieveLike(String nome) {
        return this.retrieveGeneric("exec buscarFornecedores '" + nome + "'");
    }
    
    //ATUALIZAR
    public boolean atualizar(Fornecedor fornecedor) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec atualizarFornecedores ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            stmt.setInt(1, fornecedor.getId());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getCelular());
            stmt.setString(6, fornecedor.getEmail());
            stmt.setString(7, fornecedor.getEndereco());
            stmt.setString(8, fornecedor.getCep());
            stmt.setString(9, fornecedor.getEstado());
            stmt.setString(10, fornecedor.getCidade());
            stmt.setString(11, fornecedor.getBairro());
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
    public boolean remover(int idFornecedor) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec deletarFornecedores ?");
            stmt.setInt(1, idFornecedor);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount == 1)
                return true;
        } catch (SQLException ex) {
            
        }
        return false;
    }
}
