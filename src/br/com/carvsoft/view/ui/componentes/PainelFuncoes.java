package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Funcao;
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
        setLayout(new GridLayout(8, 4));
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
