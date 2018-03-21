package br.com.carvsoft.model.dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Carlos Rafael
 */
public abstract class ConnectionFactory {
    
    private static final String USER = "postgres",
            PASSWORD = "220319",
            DATABASE = "carvsoft",
            HOST = "192.168.0.20",
            PORT = "5432",
            URL  = getUrlConnection(),
            DRIVER = "org.postgresql.Driver";

    public static Connection getConnection() throws SQLException {
        Connection connection;
        try {    
            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível conectar ao banco de dados!");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver de conexão '" + DRIVER + "' inexistente!");
        }
        return connection;
    }
    
    private static String getUrlConnection() {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:postgresql://").append(HOST).append(":").append(PORT).append("/").append(DATABASE);
        return sb.toString();
    }
    
    /*
    public static void main(String[] args) {
        try {
            ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    */
    
}
