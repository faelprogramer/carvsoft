package br.com.carvsoft.control;

import br.com.carvsoft.model.businessObject.LoginRN;
import br.com.carvsoft.model.valueObject.Usuario;
import br.com.carvsoft.view.Login;
import br.com.carvsoft.view.TelaPrincipal;
import javax.swing.JOptionPane;

/**
 * @author Carlos Rafael
 */
public class LoginControl {

    private Login login;
    private LoginRN loginRN;
    
    public LoginControl(Login login) {
        this.login = login;
        loginRN = new LoginRN();
    }
    
    public void btnOk() {
        Usuario u = new Usuario(login.getTxt_usuario().getText(),
                new String(login.getTxt_senha().getPassword()));
        if (loginRN.autenticarUsuario(u)){
            login.dispose();
            new TelaPrincipal();
        } else {
            JOptionPane.showMessageDialog(login,
                    "Não foi possível realizar a autenticação!",
                    "Usuário inválido", JOptionPane.ERROR_MESSAGE);
            login.getTxt_senha().setText("");
            login.getTxt_senha().requestFocus();
        }
        
    }
    
}
