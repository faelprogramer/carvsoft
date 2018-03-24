package br.com.carvsoft.control;

import br.com.carvsoft.model.valueObject.EnumTipoMensagem;
import br.com.carvsoft.view.ui.componentes.CustomErrorDialog;
import java.awt.Component;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Rafael
 */
public abstract class Control {

    protected void exibirMsg(Component componente, String titulo, String msg, EnumTipoMensagem tipo_mensagem) {
        tratarParaExibicao(componente, titulo, msg, tipo_mensagem, null);
    }

    protected void exibirMsg(Component componente, String titulo, String msg, EnumTipoMensagem tipo_mensagem, Exception ex) {
        tratarParaExibicao(componente, titulo, msg, tipo_mensagem, ex);
    }

    private void tratarParaExibicao(Component componente, String titulo, String msg,
            EnumTipoMensagem tipo_mensagem, Exception ex) throws HeadlessException {
        switch (tipo_mensagem) {
            case INFORMACAO:
                JOptionPane.showMessageDialog(componente, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            case ALERTA:
                JOptionPane.showMessageDialog(componente, msg, titulo, JOptionPane.WARNING_MESSAGE);
                break;
            case ERRO:
                //JOptionPane.showMessageDialog(componente, msg, titulo, JOptionPane.ERROR_MESSAGE);
                CustomErrorDialog.show(titulo, msg, ex);
                return;
            default:
                JOptionPane.showMessageDialog(componente, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
