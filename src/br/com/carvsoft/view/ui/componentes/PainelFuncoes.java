package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Funcao;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Carlos Rafael
 */
public class PainelFuncoes extends JPanel {

    private List<JButton> botoes;

    public PainelFuncoes() {
        super();
        this.botoes = new ArrayList<>();
        //setLayout(new GridLayout(0, 4, 20,20));
        setLayout(new SpringLayout());

    }

    public void setFuncoes(List<Funcao> funcoes) {
        criarListaBtnFuncoes(funcoes);
        adicionarBtnFuncoesNoPainel();
    }

    private void adicionarBtnFuncoesNoPainel() {
        for (JButton btn : botoes) {
            add(btn);
            updateUI();

        }
        SpringUtilities.makeGrid(this,
                botoes.size(), 3, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad
        updateUI();

    }

    private void criarListaBtnFuncoes(List<Funcao> funcoes) {
        for (Funcao f : funcoes) {
            botoes.add(new BtnFuncao(f));
        }
    }

    public void setFuncoes(int total) {
        for (int i = 0; i < total; i++) {
            botoes.add(new JButton("btn " + i));
        }
        for (JButton btn : botoes) {
            System.out.println(btn.getText());
        }
    }

}
