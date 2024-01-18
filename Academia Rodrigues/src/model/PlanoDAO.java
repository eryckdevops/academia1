package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlanoDAO extends DAO {
    private static PlanoDAO instance;
    private static Connection myCONN;

    private PlanoDAO() {
        
    }

    public static PlanoDAO getInstance() {
        if (instance == null) {
            instance = new PlanoDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private Plano buildObject(ResultSet rs) {
        Plano plano = null;
        try { 
            plano = new Plano(rs.getInt("id_plano"), rs.getString("nome"), rs.getString("descricao"),
                rs.getFloat("valor"), rs.getInt("vencimento"));
        } catch (SQLException e) {
            
        }
        return plano;
    }
    
    
//    CRUD
//    CADASTRO
    public boolean cadastrar(String nome, String descricao, float valor, int tempoVencimento) {
        PreparedStatement stmt;        
        try {
            stmt = myCONN.prepareStatement("exec cadastrarPlanos ?, ?, ?, ?");
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setFloat(3, valor);
            stmt.setInt(4, tempoVencimento);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if(rowCount == 1)
                return true;
        } catch (SQLException ex) {
            
        }
        return false;
    }

    //RESTAURAR
    public List<Plano> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Plano> planos = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                planos.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            
        }
        return planos;
    }

    public List<Plano> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM consultarPlanos");
    }
    
    //ATUALIZAR
    public boolean atualizar(Plano plano) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec atualizarPlanos ?, ?, ?, ?, ?");
            stmt.setInt(1, plano.getId());
            stmt.setString(2, plano.getNome());
            stmt.setString(3, plano.getDescricao());
            stmt.setFloat(4, plano.getValor());
            stmt.setInt(5, plano.getVencimento());
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
    public boolean remover(int idPlano) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("exec deletarPlanos ?");
            stmt.setInt(1, idPlano);
            int rowCount = this.executarQuery(stmt);
            stmt.close();
            if (rowCount == 1) {
                return true;
            }
        } catch (SQLException ex) {
            
        }
        return false;
    }
}
