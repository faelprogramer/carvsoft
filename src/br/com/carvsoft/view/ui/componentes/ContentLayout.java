package br.com.carvsoft.view.ui.componentes;

/**
 *
 * @author Carlos Rafael
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
public class ContentLayout extends JPanel {
    // Definição do Layout e constraints do Layout
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    public final int horizontal = GridBagConstraints.HORIZONTAL;
    public final int both = GridBagConstraints.BOTH;
    //Construtor do objeto (como o mesmo nome da classe)
    public ContentLayout(){
       layout = new GridBagLayout();
       setLayout(layout);
       constraints = new GridBagConstraints();
       constraints.weightx = 0;
       constraints.weighty = 0;
       constraints.insets = new Insets(5,5,5,5);
    }
    // Método que posiciona o componente no Frame
    public void addComponent(Component comp, int row, int column, int width, int height, int fill){
        constraints.fill = fill;
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(comp, constraints);
        add(comp);
    }
    // Método que define a borda do Frame
    public void setBorda(Color color, int thickness){
        setBorder(BorderFactory.createLineBorder(color, thickness));
    }
}