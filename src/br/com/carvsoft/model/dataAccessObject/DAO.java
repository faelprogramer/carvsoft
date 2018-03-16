package br.com.carvsoft.model.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos Rafael
 */
public abstract class DAO<E> {
    
    protected PreparedStatement pstmt;
    protected Statement stmt;
    protected ResultSet rs;
    protected String sql_insert;
    protected String sql_update;
    protected String sql_delete;
    protected String sql_select;
    
    protected ResultSet execSelect(Connection connection, String sql) throws SQLException {
        stmt = null;
        rs = null;
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
    
    private void execCommand(Connection connection, String sql) throws SQLException {
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeStmt();
        }
    }
    
    private void insert(Connection conn, E element) throws SQLException {
        try {
            pstmt = conn.prepareStatement(sql_insert);
            prepararStmtAdd(element);
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
    
    protected abstract void prepararStmtAdd(E element) throws SQLException;
    
    /*
    public static Date getDataServidor(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select current_date");
            if (rs.next()) {
                return rs.getDate(1);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        }
        return null;
    }
    
    protected java.sql.Date utilDateFromSqlDate(java.util.Date dt) {
        return new java.sql.Date(dt.getTime());
    }
    */
    
}
