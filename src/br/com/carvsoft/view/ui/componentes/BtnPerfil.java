package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Perfil;
import java.awt.Cursor;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Carlos Rafael
 */
public class BtnPerfil extends JToggleButton {

    public BtnPerfil(JPanel painel, Perfil perfil) {
        super();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setText(perfil.getDs_perfil());        
    }

    public BtnPerfil(Action a) {
        super(a);
    }

}
