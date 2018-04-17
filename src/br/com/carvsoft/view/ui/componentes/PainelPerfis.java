package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.MainApp;
import br.com.carvsoft.model.valueObject.Funcao;
import br.com.carvsoft.model.valueObject.Perfil;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos Rafael
 */
public class PainelPerfis extends JPanel {

    private List<BtnPerfil>  botoes;
    int teste = 20;
    
    public PainelPerfis(PainelFuncoes painelFuncoes) {
        super();
        setBorder(new TitledBorder("Perfis"));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        List<Perfil> perfis = getPerfisTeste(); //MainApp.SESSAO.getUsuarioAutenticado().getPerfis();
        criarListaBotoes(perfis);
        adicionarAcoesAosBotoes(painelFuncoes);
    }

    private void adicionarAcoesAosBotoes(PainelFuncoes painelFuncoes) {
        for (BtnPerfil btn : botoes) {
            btn.addActionListener((ActionEvent e) -> {
                for (BtnPerfil b : botoes) {
                    if (btn != b) {
                        b.setSelected(false);
                    }
                }
                //painelFuncoes.setFuncoes(teste--);
                painelFuncoes.setFuncoes(btn.getPerfil().getFuncoes());
            });
        }
    }

    private void criarListaBotoes(List<Perfil> perfis) {
        botoes = new ArrayList<>();
        for (Perfil p : perfis) {
            BtnPerfil btn = new BtnPerfil(p);
            botoes.add(btn);
            add(btn);
        }
    }
    
    
    
    

    private List<Perfil> getPerfisTeste() {
        List<Perfil> perfis = new ArrayList<>();
        List<Funcao> funcoes_1 = new ArrayList<>();
        List<Funcao> funcoes_2 = new ArrayList<>();

        funcoes_1.add(new Funcao(1, "tela 1", true));
        funcoes_1.add(new Funcao(2, "tela 2", true));
        funcoes_1.add(new Funcao(3, "tela 3", false));
        funcoes_2.add(new Funcao(1, "tela 1", true));
        funcoes_2.add(new Funcao(3, "tela 3", false));
        funcoes_2.add(new Funcao(5, "tela 5", true));

        Perfil p1 = new Perfil(1, "Perfil A", true);
        p1.setFuncoes(funcoes_1);

        Perfil p2 = new Perfil(2, "Perfil B", true);
        p2.setFuncoes(funcoes_2);

        Perfil p3 = new Perfil(2, "Perfil B", true);
        p3.setFuncoes(funcoes_2);
        
        Perfil p4 = new Perfil(2, "Perfil B", true);
        p4.setFuncoes(funcoes_2);
        
        perfis.add(p1);
        perfis.add(p2);
        perfis.add(p3);
        perfis.add(p4);
        return perfis;
    }

}
