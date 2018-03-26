package br.com.carvsoft.view.ui.componentes;

import br.com.carvsoft.model.valueObject.Funcao;
import br.com.carvsoft.model.valueObject.Perfil;
import br.com.carvsoft.model.valueObject.Usuario;
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

    List<Perfil> perfis;
    
    public PainelPerfis(Usuario u) {
        super();
        setBorder(new TitledBorder("Perfis"));
        //perfis = u.getPerfis();
        perfis = getPerfisTeste();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        for (Perfil p : perfis) {
            BtnPerfil btn = new BtnPerfil(this, p);
            //btn.putClientProperty("JComponent.sizeVariant", "small");
            /*
            button.putClientProperty("JButton.buttonType", "square")	
            button.putClientProperty("JButton.buttonType", "gradient")	
            button.putClientProperty("JButton.buttonType", "bevel")	
            button.putClientProperty("JButton.buttonType", "textured")	
            button.putClientProperty("JButton.buttonType", "roundRect")	
            button.putClientProperty("JButton.buttonType", "recessed")	
            button.putClientProperty("JButton.buttonType", "help")
            */
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
        
        perfis.add(p1);
        perfis.add(p2);
        return perfis;
    }
    
}
