package br.com.carvsoft.model.businessObject;

import br.com.carvsoft.model.dataAccessObject.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Carlos Rafael
 */
public abstract class RN {
    
    protected Connection connection;
    
    protected void begin() throws SQLException{
        connection = ConnectionFactory.getConnection();
        connection.setAutoCommit(true);
    }
    
    protected void end() throws SQLException {
        closeConnection();
    }
    
    protected void beginTransaction() throws SQLException {
        connection = ConnectionFactory.getConnection();
        connection.setAutoCommit(false);
    }
    
    protected void endTransaction() throws SQLException {
        connection.commit();
        closeConnection();
    }

    private void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    
    protected void roolback() throws SQLException {
        connection.rollback();
    }
    
}