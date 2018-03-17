package br.com.carvsoft.model.businessObject;

import br.com.carvsoft.model.dataAccessObject.UsuarioDAO;
import br.com.carvsoft.model.util.Password;
import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.SQLException;

/**
 * @author Carlos Rafael
 */
public class LoginRN extends RN {
   
    private final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    
    public boolean autenticarUsuario(Usuario usuario) throws SQLException, Exception {
        Usuario usuarioDoBanco;
        try {
            begin();
            usuarioDoBanco = USUARIO_DAO.getElement(connection, usuario);
            if (usuarioDoBanco == null) {
                return false;
            }
            if (!validarSenha(usuario, usuarioDoBanco)) {
                return false;
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            end();
        }
        return true;
    }

    private boolean validarSenha(Usuario usuario, Usuario usuarioDoBanco) throws Exception {
        if (usuario == null && usuarioDoBanco == null) {
            throw new Exception("O usuário informado é nulo!");
        }
        if (usuario.getDs_senha() == null && usuarioDoBanco.getDs_senha() == null) {
            throw new Exception("A senha do usuário informado é nula!");
        }
        if (usuarioDoBanco.getDs_salt() == null) {
            throw new Exception("Existe um problema com a senha do usuário, favor contatar o suporte!");
        }
        String senha1 = Password.criptografarSenha(usuario.getDs_senha(),
                usuarioDoBanco.getDs_salt());
        String senha2 = usuarioDoBanco.getDs_senha();
        return senha1.equals(senha2);
    }
    
}
