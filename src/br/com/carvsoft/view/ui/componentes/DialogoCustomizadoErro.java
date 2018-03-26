package br.com.carvsoft.view.ui.componentes;

/**
 *
 * @author Carlos Rafael
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DialogoCustomizadoErro {

    public static void show(String titulo, String msg, Exception ex) {
        if (ex != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            if (ex.getCause() != null) {
                sb.append("Cause: ").append(ex.getCause()).append("<br>");
            }
            if (ex.getMessage() != null) {
                sb.append("Message: ").append(ex.getMessage()).append("<br>");
            }
            if (ex.getLocalizedMessage() != null) {
                sb.append("Localized Message: ").append(ex.getLocalizedMessage()).append("<br>");
            }
            sb.append("Exception: ").append(ex.getClass()).append("<br>");
            sb.append("StackTrace: ").append("<br>");
            for (StackTraceElement e : ex.getStackTrace()) {
                sb.append(e.toString()).append("<br>");
            }
            sb.append("</html>");
            show(titulo, msg, sb.toString());
        } else {
            show(titulo, msg, "Detalhes não informados!");
        }
    }

    private static void show(String titulo, String msg, String detalhes) {
        final JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");

        textPane.setText(detalhes);
        textPane.setEditable(false);
        textPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        final JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setAlignmentX(Component.TOP_ALIGNMENT);

        final JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        final JDialog dialog = new JOptionPane(
                content,
                JOptionPane.ERROR_MESSAGE,
                JOptionPane.DEFAULT_OPTION).createDialog(null, titulo);

        JLabel message = new JLabel(msg);
        message.setBorder(new EmptyBorder(10, 10, 10, 10));
        message.setAlignmentX(Component.TOP_ALIGNMENT);
        //Dimension labelSize = message.getPreferredSize();
        //labelSize.setSize(300, labelSize.height);
        //message.setPreferredSize(labelSize);
        content.add(message);

        JCheckBox cb = new JCheckBox(new AbstractAction() {

            private static final long serialVersionUID = 1L;

            {
                this.putValue(Action.SELECTED_KEY, false);
                this.putValue(Action.NAME, "Detalhar");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Boolean) this.getValue(Action.SELECTED_KEY)) {
                    content.add(scrollPane);
                } else {
                    content.remove(scrollPane);
                }
                content.invalidate();
                dialog.invalidate();
                dialog.pack();
            }
        });
        content.add(cb);
        cb.setBorder(new EmptyBorder(0, 0, 10, 0));
        dialog.setResizable(false);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
