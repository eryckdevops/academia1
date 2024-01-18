package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemPedidoDAO extends DAO {
    
    private static ItemPedidoDAO instance;
    private static Connection myCONN;

    private ItemPedidoDAO() {
    }

    public static ItemPedidoDAO getInstance() {
        if (instance == null) {
            instance = new ItemPedidoDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            if(myCONN == null) {
                try {
                myCONN = instance.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return instance;
    }
    
    private ItemPedido buildObject(ResultSet rs) {
        ItemPedido itemPedido = null;
        try { 
            itemPedido = new ItemPedido(rs.getInt("id_venda"), rs.getInt("id_produto"), rs.getInt("quantidade"));
        } catch (SQLException e) {
            
        }
        return itemPedido;
    }

//    public static void main(String[] args) {
//        System.out.println(ItemPedidoDAO.getInstance().remover(new ItemPedido(1,2, 200)));
//    }
    
    //CRUD
    //CADASTRO
    public boolean cadastrar(int idVenda, int idProduto, int qtd) {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareStatement("exec cadastrarItemPedidos ?, ?, ?");
            stmt.setInt(1, idVenda);
            stmt.setInt(2, idProduto);
            stmt.setInt(3, qtd);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount != 0) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    //RESTAURAR
    public List<ItemPedido> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<ItemPedido> itemPedidos = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while(rs.next()) {
                itemPedidos.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            
        }
        return itemPedidos;
    }

    public List<ItemPedido> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM consultarItemPedidos");
    }

    public List<ItemPedido> retrieveLike(int idVenda) {
        return this.retrieveGeneric("exec buscarItemPedidos '" + idVenda + "'");
    }
    
    //ATUALIZAR
    public boolean atualizar(ItemPedido itemPedido) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec atualizarItemPedidos  ?, ?, ?");
            stmt.setInt(1, itemPedido.getIdVenda());
            stmt.setInt(2, itemPedido.getIdProduto());
            stmt.setInt(3, itemPedido.getQtd());
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if (rowCount !=0 ) {
                return true;
            }
        } catch (SQLException ex) {
            
        }
        return false;
    }
    
    //REMOVER
    public boolean remover(ItemPedido itemPedido) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec deletarItemPedidos ?, ?");
            stmt.setInt(1, itemPedido.getIdVenda());
            stmt.setInt(2, itemPedido.getIdProduto());
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount != 0)
                return true;
            } catch (SQLException ex) {
            
            }
        return false;
    }
}
