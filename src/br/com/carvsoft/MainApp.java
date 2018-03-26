package br.com.carvsoft;

import br.com.carvsoft.view.Login;
import com.alee.laf.WebLookAndFeel;

/**
 *
 * @author Rafael Carvalhal
 */
public class MainApp implements Runnable {

    public static void main(String[] args) {
        new MainApp().run();
    }

    @Override
    public void run() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "Carv Soft");
        } else {
            WebLookAndFeel.install();
        }

        Login l = new Login();
    }

}
