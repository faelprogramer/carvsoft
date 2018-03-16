package br.com.carvsoft.model.dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Carlos Rafael
 */
public class ConnectionFactory {
    
    private final String USER, PASSWORD, DATABASE, HOST, PORT, URL, DRIVER;
    
    public ConnectionFactory() {
        USER = "postgres";
        PASSWORD = "220319";
        DATABASE = "carvsoft";
        HOST = "192.168.0.20";
        PORT = "5432";
        DRIVER = "org.postgresql.Driver";
        URL = getUrlConnection();
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection;
        try {    
            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
        return connection;
    }
    
    private String getUrlConnection() {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:postgresql://").append(HOST).append(":").append(PORT).append("/").append(DATABASE);
        return sb.toString();
    }
    
    /*
    public static void main(String[] args) {
        try {
            Connection c = new ConnectionFactory().getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro de conexão!");
        }
    }
    */
}
