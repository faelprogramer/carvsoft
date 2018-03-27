package br.com.carvsoft.view.ui.componentes;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Rafael
 */
public class PainelFuncoes extends JPanel {

    private List<JButton> botoes;

    public PainelFuncoes() {
        super();
        this.botoes = new ArrayList<>();
        setLayout(new GridLayout(4, 10));
        for (JButton btn : botoes) {
            add(btn);
        }
    }

    public void setFuncoes(int total) {
        for (int i = 0; i < total; i++) {
            botoes.add(new JButton("btn " + i));
        }
    }
}
