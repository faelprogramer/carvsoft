package br.com.carvsoft;

import br.com.carvsoft.model.valueObject.Sessao;
import br.com.carvsoft.view.Login;
import com.alee.laf.WebLookAndFeel;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rafael Carvalhal
 */
public class MainApp implements Runnable {

    public static final Sessao SESSAO = new Sessao();
    
    static {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "Carv Soft");
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {}
        } else {
            WebLookAndFeel.install();
        }
        SESSAO.setDs_versao_sistema("BETA");
        SESSAO.setNm_usuario_os(System.getProperty("user.name"));
        try {
            SESSAO.setNm_maquina(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ex) {}
    }

    public static void main(String[] args) {
        new MainApp().run();
    }

    @Override
    public void run() {
        Login l = new Login();
    }

}
