package br.com.carvsoft.model.businessObject;

import br.com.carvsoft.model.valueObject.Usuario;

/**
 * @author Carlos Rafael
 */
public class LoginRN {
    
    public boolean autenticarUsuario(Usuario u) {
        return u.getNm_usuario().equals("1234") && u.getDs_senha().equals("1234");
    }
}
