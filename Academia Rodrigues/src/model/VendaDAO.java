package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO extends DAO {
    private static VendaDAO instance;
    private static Connection myCONN;

    private VendaDAO() {
    }

    public static VendaDAO getInstance() {
        if (instance == null) {
            instance = new VendaDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private Venda buildObject(ResultSet rs) {
        Venda venda = null;
        try { 
            venda = new Venda(rs.getInt("id_venda"), rs.getInt("id_cliente"), rs.getInt("id_funcionario"), 
                rs.getInt("status"), rs.getFloat("total"), rs.getString("dt_venda"));
        } catch (SQLException e) {
        }
        return venda;
    }
   
    
    //CRUD
    //CADASTRO
    /**
     O cadastro de venda deve retornar o ID da venda criada, para que possa ser usado no cadastro de itens da venda
     */
    public boolean cadastrar() {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareStatement("exec cadastrarVendas");
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount != 0) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

//    public static void main(String[] args) {
//        List<Venda> vendas = VendaDAO.getInstance().retrieveByDate("2018-11-28");
//        java.util.Iterator<Venda> iterator = vendas.iterator();
//        
//        while(iterator.hasNext()) {
//            Venda venda = iterator.next();
//            System.out.println("ID: " + venda.getIdVenda());
//            System.out.println("Cliente: " + venda.getIdCliente());
//            System.out.println("Funcionário: " + venda.getIdFuncionario());
//            System.out.println("Status: " + venda.getStatus());
//            System.out.println("Total: " + venda.getTotal());
//            System.out.println("Data: " + venda.getDtVenda());
//            System.out.println("------------------------");
//        }
//    }
    
    //RESTAURAR
    public List<Venda> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Venda> vendas = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                vendas.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            
        }
        return vendas;
    }

    public List<Venda> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM consultarVendas");
    }

    public List<Venda> retrieveByDate(String data) {
        return this.retrieveGeneric("exec buscarVendasPorData '" + data + "'");
    }

    //ATUALIZAR
        public boolean atualizar(int idVenda, int idCliente, int idFuncionario) {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareStatement("exec atualizarVendas ?, ?, ?");
            stmt.setInt(1, idVenda);
            stmt.setInt(2, idCliente);
            stmt.setInt(3, idFuncionario);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount != 0) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    //REMOVER
    public boolean remover(int idVenda) {
        PreparedStatement stmt;
        try {            
            stmt = myCONN.prepareStatement("exec deletarVendas ?");
            stmt.setInt(1, idVenda);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount != 0)
                return true;
        } catch (SQLException ex) {

        }
        return false;
    }
    
    
    public int getUltimoId() {
        PreparedStatement stmt;  
        ResultSet rs;     
        int id = -1;
        
        try {
            stmt = myCONN.prepareStatement("SELECT max(id_venda) as id_venda FROM acd_Vendas");
            rs = this.getResultSet(stmt);
            if (rs.next()) {
                id = rs.getInt("id_venda");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {            
        }
        
        return id;
    }
}