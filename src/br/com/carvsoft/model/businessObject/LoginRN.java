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
            if (!testarSenha(u, user)) {
                user = null;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            end();
        }
        return user != null;
    }

    private boolean testarSenha(Usuario u, Usuario user) {
        if (u != null && u.getDs_senha() != null && user != null && user.getDs_senha() != null) {
            return u.getDs_senha().equals(user.getDs_senha());
        }
        return false;
    }
}
