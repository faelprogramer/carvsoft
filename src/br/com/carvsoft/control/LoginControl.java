package br.com.carvsoft.control;

import br.com.carvsoft.model.businessObject.LoginRN;
import br.com.carvsoft.model.valueObject.EnumTipoMensagem;
import br.com.carvsoft.model.valueObject.Usuario;
import br.com.carvsoft.model.valueObject.exceptions.AttemptExceededException;
import br.com.carvsoft.view.Login;
import br.com.carvsoft.view.TelaPrincipal;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.naming.AuthenticationException;

/**
 * @author Carlos Rafael
 */
public class LoginControl extends Control {

    private final Login login;
    private LoginRN loginRN;

    public LoginControl(Login login) {
        this.login = login;
        loginRN = new LoginRN();
        login.getTxt_usuario().setText("rafael");
        login.getTxt_senha().setText("1234");
    }

    public void btnOk() {
        try {
            Usuario u = loginRN.autenticar(instanciarUsuario());
            if (u != null) {
                login.dispose();
                new TelaPrincipal();
            }
        } catch (SQLException | AuthenticationException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            exibirMsg(login, "Erro", ex.getMessage(), EnumTipoMensagem.ERRO, ex);
        } catch (AttemptExceededException ex) {
            exibirMsg(login, null, ex.getMessage(), EnumTipoMensagem.ERRO, ex);
            System.exit(0);
        }
    }

    private Usuario instanciarUsuario() {
        return new Usuario(login.getTxt_usuario().getText(),
                new String(login.getTxt_senha().getPassword()));
    }

}
