package br.com.carvsoft.view;

import br.com.carvsoft.model.valueObject.Usuario;
import br.com.carvsoft.view.ui.componentes.PainelFuncoes;
import br.com.carvsoft.view.ui.componentes.PainelPerfis;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class TelaPrincipal extends JFrame {

    private Container pane;
    private PainelPerfis painelPerfis;
    private JScrollPane scrollPaneFuncoes;
    private JMenuBar menuBar;
    private JMenu jMenu_arquivo;
    private JMenuItem menuItemSair;
    private final Usuario usuarioLogado;
    LookAndFeel lf;

    public TelaPrincipal(Usuario u) {
        super("Carv Soft");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        usuarioLogado = u;
        initComponents(usuarioLogado);
        menuItemSair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        this.setVisible(true);
    }

    private void initComponents(Usuario u) {
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        pane = this.getContentPane();
        adicionarMenus();

        
        JButton button;
        PainelFuncoes pf = new PainelFuncoes();
        
        painelPerfis = new PainelPerfis(u, pf);
        //button = new JButton("Button 3 (LINE_START)");
        //pane.add(button, BorderLayout.LINE_START);
        pane.add(painelPerfis, BorderLayout.LINE_START);

        
        
        scrollPaneFuncoes = new JScrollPane();
        scrollPaneFuncoes.setBorder(new TitledBorder("Funções"));
        scrollPaneFuncoes.setBackground(pf.getBackground());
        scrollPaneFuncoes.setViewportView(pf);
        pane.add(scrollPaneFuncoes, BorderLayout.CENTER);
        
        
        
        
        
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);

        //button = new JButton("5 (LINE_END)");
        //pane.add(button, BorderLayout.LINE_END);
        this.pack();
    }

    private void adicionarMenus() {
        menuBar = new JMenuBar();
        
        jMenu_arquivo = new JMenu("Arquivo");
        menuItemSair = new JMenuItem("Sair");
        jMenu_arquivo.add(menuItemSair);
        menuBar.add(jMenu_arquivo);
        setJMenuBar(menuBar);
    }

}
