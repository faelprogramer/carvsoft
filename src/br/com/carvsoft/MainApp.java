package br.com.carvsoft;

import br.com.carvsoft.view.Login;
import com.alee.laf.WebLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rafael Carvalhal
 */
public class MainApp implements Runnable {

    static {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "Carv Soft");
            try {
                //UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                //UIManager.setLookAndFeel("Mac OS X");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
        } else {
            WebLookAndFeel.install();
        }
    }

    public static void main(String[] args) {
        new MainApp().run();
    }

    @Override
    public void run() {
        Login l = new Login();
    }

}
