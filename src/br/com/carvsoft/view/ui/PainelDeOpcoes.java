package br.com.carvsoft.view.ui;

import br.com.carvsoft.model.valueObject.EnumTipoMensagem;
import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Rafael
 */

public class PainelDeOpcoes {

    public void exibirMsg(Component componente, String titulo, String msg, EnumTipoMensagem tipo_mensagem) {
        tratarParaExibicao(componente, titulo, msg, tipo_mensagem, null);
    }
    
    public void exibirMsg(Component componente, String msg, String titulo, EnumTipoMensagem tipo_mensagem, Exception ex) {
        tratarParaExibicao(componente, titulo, msg, tipo_mensagem, ex);
    }

    private void tratarParaExibicao(Component componente, String titulo, String msg, EnumTipoMensagem tipo_mensagem, Exception ex) throws HeadlessException {
        int ie_tipo_mensagem;
        switch (tipo_mensagem) {
            case INFORMACAO:
                ie_tipo_mensagem = JOptionPane.INFORMATION_MESSAGE;
                break;
            case ALERTA:
                ie_tipo_mensagem = JOptionPane.WARNING_MESSAGE;
                break;
            case ERRO:
                //ie_tipo_mensagem = JOptionPane.ERROR_MESSAGE;
                CustomErrorDialog.show(titulo, msg, ex);
                return;
            default:
                ie_tipo_mensagem = JOptionPane.INFORMATION_MESSAGE;
        }
        JOptionPane.showMessageDialog(componente, msg, titulo, ie_tipo_mensagem);
    }
    
}