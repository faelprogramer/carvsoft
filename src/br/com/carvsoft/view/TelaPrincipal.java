package br.com.carvsoft.view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TelaPrincipal extends JFrame {

    private BorderLayout borderLayout;
    private Container pane;
    private JMenuBar menuBar;
    private JMenu jMenu_arquivo;
    

    public TelaPrincipal() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        borderLayout = new BorderLayout();
        pane = this.getContentPane();
        menuBar = new JMenuBar();
        jMenu_arquivo = new JMenu("Arquivo");
        
        menuBar.add(jMenu_arquivo);
        setJMenuBar(menuBar);
        
        
        JButton button;
        
        button = new JButton("Button 2 (CENTER)");
        
        pane.add(button, BorderLayout.CENTER);

        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);

        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);

        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
        
        this.pack();
        this.setVisible(true);
    }

    
}