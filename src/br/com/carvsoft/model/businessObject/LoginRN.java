package br.com.carvsoft.model.businessObject;

import br.com.carvsoft.model.dataAccessObject.UsuarioDAO;
import br.com.carvsoft.model.util.Password;
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

    private boolean validarSenha(Usuario usuario, Usuario usuarioDoBanco) throws AuthenticationException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (usuario == null) {
            throw new AuthenticationException("O usuário informado é inválido!");
        }
        if (usuario.getDs_senha() == null || usuario.getDs_senha().isEmpty()) {
            throw new AuthenticationException("A senha do usuário informado não pode estar vazia!");
        }
        if (usuarioDoBanco == null) {
            return false;
        }
        if (usuarioDoBanco.getVf_ativo()) {
            throw new AuthenticationException("Usuário inativo!");
        }
        String senhaDigitada = Password.criptografarSenha(usuario.getDs_senha(),
                usuarioDoBanco.getDs_salt());
        return senhaDigitada.equals(usuarioDoBanco.getDs_senha());
    }

    public boolean verificarAutenticidadeUsuario(Usuario usuario) throws SQLException, AuthenticationException, NoSuchAlgorithmException, UnsupportedEncodingException, AttemptExceededException {
        Usuario usuarioDoBanco;
        if (qtErroAutenticacao > 2) {
            throw new AttemptExceededException();
        }
        try {
            begin();
            usuarioDoBanco = USUARIO_DAO.getElement(connection, usuario);
            if (!validarSenha(usuario, usuarioDoBanco)) {
                qtErroAutenticacao++;
                return false;
            }
            return true;
        } catch (SQLException | AuthenticationException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw ex;
        } finally {
            end();
        }
    }
    
    public int getQtErroAutenticacao() {
        return qtErroAutenticacao;
    }

}
