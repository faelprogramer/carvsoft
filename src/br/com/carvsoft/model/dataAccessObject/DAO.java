package br.com.carvsoft.model.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Rafael
 */
public abstract class DAO<E> {
    
    protected PreparedStatement pstmt;
    protected Statement stmt;
    protected ResultSet rs;
    private final String SQL_GET_DATA_ATUAL = "select current_date";
    protected String sql_insert;
    protected String sql_update;
    protected String sql_delete;
    protected String sql_select;
    
    public void save(Connection connection, E element) throws SQLException {
        if(!exists(connection, element)) {
            insert(connection, element);
        } else {
            update(connection, element);
        }
    }
    
    public void delete(Connection connection, E element) throws SQLException {
        try {
            pstmt = connection.prepareStatement(sql_delete);
            prepararStmtDelete(element);
            pstmt.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closePstmt();
        }
    }
    
    public E getElement(Connection connection, E element) throws SQLException {
        try {
            pstmt = connection.prepareStatement(sql_select);
            prepararStmtSelectElement(element);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return InstantElementFromResultSet();
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closePstmt();
            closeRs();
        }
        return null;
    }
    
    public List<E> getElements(Connection connection, String sql) throws SQLException {
        List<E> elements = new ArrayList<>();
        rs = execSelect(connection, sql);
        while (rs.next()) {            
            elements.add(InstantElementFromResultSet());
        }
        return elements;
    }
    
    public java.util.Date getDataServer(Connection conn) throws SQLException {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_DATA_ATUAL);
            if (rs.next()) {
                return rs.getDate(1);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeStmt();
            closeRs();
        }
        return null;
    }
    
    protected java.sql.Date DateToSqlDate(java.util.Date dt) {
        return new java.sql.Date(dt.getTime());
    }
    
    protected ResultSet execSelect(Connection connection, String sql) throws SQLException {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeStmt();
            closeRs();
        }
        return rs;
    }
    
    protected void execCommand(Connection connection, String sql) throws SQLException {
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeStmt();
        }
    }
    
    
    protected abstract void prepararStmtInsert(Connection connection, E element) throws SQLException;
    
    protected abstract void prepararStmtUpdate(Connection connection, E element) throws SQLException;
    
    protected abstract void prepararStmtDelete(E element) throws SQLException;
    
    protected abstract void prepararStmtSelectElement(E element) throws SQLException;
    
    protected abstract E InstantElementFromResultSet() throws SQLException;
    
    
    private boolean exists(Connection connection, E element) throws SQLException {
        return getElement(connection, element) != null;
    }
    
    private void insert(Connection connection, E element) throws SQLException {
        try {
            pstmt = connection.prepareStatement(sql_insert);
            prepararStmtInsert(connection, element);
            pstmt.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closePstmt();
        }
    }
    
    private void update(Connection connection, E element) throws SQLException {
        try {
            pstmt = connection.prepareStatement(sql_update);
            prepararStmtUpdate(connection, element);
            pstmt.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closePstmt();
        }
    }
    
    private void closeRs() throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    private void closePstmt() throws SQLException {
        if (pstmt != null && !pstmt.isClosed()) {
            pstmt.close();
        }
    }

    private void closeStmt() throws SQLException {
        if (stmt != null && !stmt.isClosed()) {
            stmt.close();
        }
    }

}