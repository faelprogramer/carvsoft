package br.com.carvsoft.view;

import br.com.carvsoft.control.LoginControl;
import br.com.carvsoft.view.ui.UpperCaseDocument;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * @author Carlos Rafael
 */
public class Login extends JFrame {

    
    private LoginControl control;
    private JButton btn_ok;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPasswordField txt_senha;
    private JTextField txt_usuario;
    private JLabel lb_login;
    private JLabel lb_senha;
    private JLabel lb_usuario;

    public Login() {
        initComponents();
        setIcone();
        control = new LoginControl(this);
    }

    private void setIcone() {
        URL url = this.getClass().getResource("/br/com/carvsoft/view/resources/app.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(iconeTitulo);
    }

    private void btn_okActionPerformed(ActionEvent e) {
        control.btnOk();
    }

    private void initComponents() {
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        
        jPanel1 = new JPanel();
        lb_login = new JLabel();
        lb_usuario = new JLabel();
        txt_usuario = new JTextField();
        lb_senha = new JLabel();
        txt_senha = new JPasswordField();
        jPanel2 = new JPanel();
        btn_ok = new JButton();

        jPanel1.setBackground(Color.WHITE);
        jPanel2.setBackground(jPanel1.getBackground());

        lb_login.setHorizontalAlignment(SwingConstants.CENTER);
        lb_login.setIcon(new ImageIcon(getClass().getResource("/br/com/carvsoft/view/resources/login/login.png")));

        lb_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        lb_usuario.setIcon(new ImageIcon(getClass().getResource("/br/com/carvsoft/view/resources/login/user.png")));

        txt_usuario.setHorizontalAlignment(JTextField.CENTER);
        txt_usuario.setDocument(new UpperCaseDocument());
        txt_senha.setHorizontalAlignment(JTextField.CENTER);

        lb_senha.setHorizontalAlignment(SwingConstants.CENTER);
        lb_senha.setIcon(new ImageIcon(getClass().getResource("/br/com/carvsoft/view/resources/login/password.png")));

        btn_ok.setIcon(new ImageIcon(getClass().getResource("/br/com/carvsoft/view/resources/login/ok.png")));
        btn_ok.addActionListener((ActionEvent evt) -> {
            btn_okActionPerformed(evt);
        });
        getRootPane().setDefaultButton(btn_ok);

        montarLayout();

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void montarLayout() {
        jPanel2.add(btn_ok);

        GroupLayout gl = new GroupLayout(jPanel1);
        jPanel1.setLayout(gl);
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_login, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(lb_usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_usuario)
                                .addComponent(lb_senha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_senha))
                        .addContainerGap())
        );
        gl.setVerticalGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_login)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_usuario)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_senha)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

    public JPasswordField getTxt_senha() {
        return txt_senha;
    }

    public JTextField getTxt_usuario() {
        return txt_usuario;
    }
    
}
