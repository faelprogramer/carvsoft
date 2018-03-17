package br.com.carvsoft.control;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Rafael
 */
public abstract class Control {

    protected void exibirMsgErro(Component parentComponent, String titulo, String msg) {
        JOptionPane.showMessageDialog(parentComponent, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
}
