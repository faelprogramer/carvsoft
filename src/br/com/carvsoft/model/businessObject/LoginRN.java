package br.com.carvsoft.model.businessObject;

import br.com.carvsoft.model.dataAccessObject.UsuarioDAO;
import br.com.carvsoft.model.valueObject.Usuario;
import br.com.carvsoft.model.valueObject.exceptions.AttemptExceededException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.naming.AuthenticationException;

/**
 * @author Carlos Rafael
 */
public class LoginRN extends RN {

    private final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    private int qtErroAutenticacao = 0;

    private boolean validarUsuario(Usuario usuario, Usuario usuarioDoBanco) throws AuthenticationException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (usuario == null) {
            qtErroAutenticacao++;
            throw new AuthenticationException("Usuário informado inválido!");
        }
        if (usuario.getDs_senha() == null || usuario.getDs_senha().isEmpty()) {
            qtErroAutenticacao++;
            throw new AuthenticationException("A senha do usuário informado não pode estar vazia!");
        }
        if (usuarioDoBanco == null) {
            qtErroAutenticacao++;
            throw new AuthenticationException("Usuário não encontrado!");
        }
        if (!usuarioDoBanco.getVf_ativo()) {
            qtErroAutenticacao++;
            throw new AuthenticationException("Usuário inativo!");
        }
        if (usuarioDoBanco.validarSenha(usuario.getDs_senha())) {
            return true;
        } else {
            qtErroAutenticacao++;
            throw new AuthenticationException("Senha inválida!");
        }
    }

    public Usuario autenticar(Usuario usuario) throws SQLException, AuthenticationException, NoSuchAlgorithmException, UnsupportedEncodingException, AttemptExceededException {
        Usuario usuarioDoBanco;
        if (qtErroAutenticacao > 2) {
            throw new AttemptExceededException();
        }
        try {
            begin();
            usuarioDoBanco = USUARIO_DAO.getElement(connection, usuario);
            if (validarUsuario(usuario, usuarioDoBanco) == true) {
                return usuarioDoBanco;
            }
            return null;
        } catch (SQLException | AuthenticationException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw ex;
        } finally {
            end();
        }
    }

}
