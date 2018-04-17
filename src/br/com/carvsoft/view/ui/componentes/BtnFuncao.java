package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Funcao;
import java.awt.Cursor;
import javax.swing.JButton;

/**
 *
 * @author Carlos Rafael
 */
public class BtnFuncao extends JButton {
    
    private Funcao funcao;

    public BtnFuncao(Funcao funcao) {
        super(funcao.getDs_funcao());
        this.funcao = funcao;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

}
