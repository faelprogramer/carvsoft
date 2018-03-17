package br.com.carvsoft.model.businessObject;

import br.com.carvsoft.model.dataAccessObject.UsuarioDAO;
import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.SQLException;

/**
 * @author Carlos Rafael
 */
public class LoginRN extends RN {
   
    private UsuarioDAO uDAO = new UsuarioDAO();
    
    public boolean ValidarSenhaDoUsuario(Usuario u) throws SQLException {
        Usuario user;
        try {
            begin();
            user = uDAO.getElement(connection, u);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            end();
        }
        return user != null;
    }
}
