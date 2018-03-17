package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.PessoaFisica;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Carlos Rafael
 */
public class PessoaFisicaDAO extends DAO<PessoaFisica>{

    @Override
    protected void configurarSqlDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void prepararStmtInsert(Connection connection, PessoaFisica element) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void prepararStmtUpdate(Connection connection, PessoaFisica element) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void prepararStmtDelete(PessoaFisica element) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void prepararStmtSelectElement(PessoaFisica element) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected PessoaFisica InstantElementFromResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
