package br.com.carvsoft.control;

import br.com.carvsoft.model.businessObject.LoginRN;
import br.com.carvsoft.model.valueObject.Usuario;
import br.com.carvsoft.view.Login;
import br.com.carvsoft.view.TelaPrincipal;
import java.sql.SQLException;

/**
 * @author Carlos Rafael
 */
public class LoginControl extends Control {

    private Login login;
    private LoginRN loginRN;
    private int qtErroSenha;

    public LoginControl(Login login) {
        this.login = login;
        loginRN = new LoginRN();
    }

    public void btnOk() {
        Usuario u = instanciarUsuario();
        try {
            if (loginRN.verificarAutenticidadeUsuario(u)) {
                login.dispose();
                new TelaPrincipal();
            } else {
                qtErroSenha++;
                if (qtErroSenha == 3) {
                    exibirMsgErro(login, "Erro",
                            "A quantidade máxima de tentativas foi superada, o sistema será finalizado!");
                    System.exit(0);
                }
                exibirMsgErro(login, "Erro", "Usuário ou senha inválida!");
                login.getTxt_senha().setText("");
                login.getTxt_senha().requestFocus();
            }
        } catch (SQLException ex) {
            exibirMsgErro(login, "Erro",
                    "Não foi possível realizar a conexão com o banco de dados, o sistema será finalizado!");
            System.exit(-1);
        } catch (Exception ex) {
            exibirMsgErro(login, "Erro", ex.getMessage());
        }

    }

    private Usuario instanciarUsuario() {
        return new Usuario(login.getTxt_usuario().getText(),
                new String(login.getTxt_senha().getPassword()));
    }

}
