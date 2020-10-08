package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.cmd;
import vista.fromPrincipal;

/**
 *
 * @author Telematico
 */
public class controladorFromPrincipal implements ActionListener {

    public static fromPrincipal fp = null;
    private static String ruta;

    public controladorFromPrincipal(fromPrincipal fp,String ruta) {
        this.fp = fp;
        this.ruta = ruta;
        inicializar();
    }

    private void inicializar() {
        this.fp.btnEjecutar.addActionListener(this);
        this.fp.setVisible(true);
        this.fp.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.fp.btnEjecutar)) {
            fp.txtArea.setText("");
            if (fp.txtQuery.getText().equals("lol")) {
                JOptionPane.showMessageDialog(null, "Error no se permiten valores nulos!", "Error", 0);
            } else {
                cmd c = new cmd(ruta,"git ");
                c.getLine(this.fp.txtQuery.getText());
            }
        }
    }

}
