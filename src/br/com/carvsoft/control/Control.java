package br.com.carvsoft.control;

import br.com.carvsoft.model.valueObject.EnumTipoMensagem;
import br.com.carvsoft.view.ui.PainelDeOpcoes;
import java.awt.Component;

/**
 *
 * @author Carlos Rafael
 */
public abstract class Control {

    protected void exibirMsg(Component parentComponent, String titulo, String msg, EnumTipoMensagem enum_tipo_mensagem, Exception ex) {
        PainelDeOpcoes.exibirMsg(parentComponent, titulo, msg, enum_tipo_mensagem, ex);
    }
    
}
