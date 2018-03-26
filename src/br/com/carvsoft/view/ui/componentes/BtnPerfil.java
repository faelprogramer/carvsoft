package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Perfil;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Carlos Rafael
 */
public class BtnPerfil extends JToggleButton {

    public BtnPerfil(JPanel painel, Perfil perfil) {
        setText(perfil.getDs_perfil());
        addActionListener((ActionEvent evt) -> {
            acao(evt);
        });
    }

    public BtnPerfil(Action a) {
        super(a);
    }

    private void acao(ActionEvent evt) {
        System.out.println("Btn " + getText() + " selecionado: " + isSelected());
    }
}
