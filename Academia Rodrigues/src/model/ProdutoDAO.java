package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO extends DAO{
    private static ProdutoDAO instance;
    private static Connection myCONN;

    private ProdutoDAO() {
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private Produto buildObject(ResultSet rs) {
        Produto produto = null;
        try { 
            produto = new Produto(rs.getInt("id_produto"), rs.getString("nome"), rs.getString("descricao"), 
                rs.getInt("qtd_estoque"), rs.getFloat("preco"));
        } catch (SQLException e) {
        }
        return produto;
    }

    
    //CRUD
    //CADASTRO
    public boolean cadastrar(String nome, String descricao, int qtdEstoque, float preco) {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareCall("exec cadastrarProdutos ?, ?, ?, ?");
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setInt(3, qtdEstoque);
            stmt.setFloat(4, preco);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount == 1)
                return true;
            
        } catch (SQLException ex) {
        }
        return false;
    }
    
    //RESTAURAR
    public List<Produto> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Produto> produtos = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                produtos.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            
        }
        return produtos;
    }

    public List<Produto> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM consultarProdutos");
    }

    public List<Produto> retrieveLike(String nome) {
        return this.retrieveGeneric("exec buscarProdutos '" + nome + "'");
    }
   
    //ATUALIZAR
    public boolean atualizar(Produto produto) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec atualizarProdutos ?, ?, ?, ?, ?");
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getQtdEstoque());
            stmt.setFloat(5, produto.getPreco());
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
    public boolean remover(int idProduto) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareCall("exec deletarProdutos ?");
            stmt.setInt(1, idProduto);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount == 1)
                return true;
        } catch (SQLException ex) {
            
        }
        return false;
    }
}
