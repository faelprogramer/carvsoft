package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Perfil;
import java.awt.Cursor;

import javax.swing.Action;
import javax.swing.JToggleButton;

/**
 *
 * @author Carlos Rafael
 */
public class BtnPerfil extends JToggleButton {

    private Perfil perfil;
    
    public BtnPerfil(Perfil perfil) {
        super(perfil.getDs_perfil());
        this.perfil = perfil;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public BtnPerfil(Action a) {
        super(a);
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
