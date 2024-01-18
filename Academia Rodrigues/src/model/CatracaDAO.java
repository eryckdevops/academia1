package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class CatracaDAO extends DAO {

    private static CatracaDAO instance;
    private static Connection myCONN;

    private CatracaDAO() {
    }

    public static CatracaDAO getInstance() {
        if (instance == null) {
            instance = new CatracaDAO();
            try {
                myCONN = instance.getConnection();
            } catch (SQLException ex) {
            }
            
            if (myCONN == null)
                return null;
        }
        return instance;
    }
   
    public Boolean verificaExistenciaCartao(String cartao) {
        Boolean retorno = false;
        PreparedStatement stmt;
        ResultSet rs;
        
        Date date = new Date();        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        String data = ano+"-"+mes+"-"+dia;
        
        try {
            stmt = myCONN.prepareStatement("SELECT cartao FROM consultarFuncionarios WHERE cartao = '" + cartao + "'");
            rs = this.getResultSet(stmt);
            retorno = rs.next();
            rs.close();
            stmt.close();   
        } catch (SQLException ex) {
        }
        
        if (!retorno) {
            try {
                stmt = myCONN.prepareStatement("SELECT id_cliente FROM consultarClientes WHERE cartao = '" + cartao + "' AND dt_vencimento >= '" + data + "'");
                rs = this.getResultSet(stmt);
                retorno = rs.next();                        
                rs.close();
                stmt.close();   
            } catch (SQLException ex) {
            }
            
            if (retorno)
            try {
                stmt = myCONN.prepareStatement("UPDATE acd_Clientes set ultimoAcesso = '" + data + "' WHERE id_cliente = '" + retorno + "'");
                rs = this.getResultSet(stmt);                   
                rs.close();
                stmt.close();   
            } catch (SQLException ex) {
            }
        }
        
        return retorno;
    }
}

