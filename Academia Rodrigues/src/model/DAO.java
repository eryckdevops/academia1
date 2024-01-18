package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
    private static Connection con;
    private static final String DBURL = "jdbc:sqlserver://ftdbinstance.c531nllodu25.sa-east-1.rds.amazonaws.com:1433;databaseName=bancoVini;user=felipemarchi;password=ftlimeira";

    protected Connection getConnection() throws SQLException {
        if (con == null)
            con = DriverManager.getConnection(DBURL);
        return con;
    }

    protected ResultSet getResultSet(PreparedStatement queryStatement) throws SQLException {
        ResultSet rs;
        rs = queryStatement.executeQuery();
        return rs;
    }

    protected int executarQuery(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected void terminar() {
        try {
            this.getConnection().close();
        } catch (SQLException e) {
            
        }
    }
}
