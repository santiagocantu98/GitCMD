package modelo;

import controlador.controladorFromPrincipal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Telematico
 */
public class cmd implements Runnable {

    private static String query;
    private static boolean control = false;
    private static String ruta;
    private static String comando;

    public cmd(String ruta,String comando) {
        this.ruta = ruta;
        this.comando = comando;
        this.comando = (String)controladorFromPrincipal.fp.jComboBox1.getSelectedItem();
        Thread hilo = new Thread(this);
        hilo.start();
        controladorFromPrincipal.fp.txtRuta.setText(this.ruta);
    }

    public void getLine(String query) {
        cmd.query = query;
        cmd.control = true;
    }

    @Override
    public void run() {
        Runtime r = Runtime.getRuntime();
        String salida = null;
        int i = 1;
        try {
            Process p = r.exec("cmd /c" + "cd " + ruta +" && " + comando + " " + query);
            InputStreamReader entrada = new InputStreamReader(p.getInputStream());
            BufferedReader cmdInput = new BufferedReader(entrada);
            System.out.println(cmdInput.readLine());
            //mostramos la salida del comando
            while ((salida = cmdInput.readLine()) != null) {
                controladorFromPrincipal.fp.txtArea.append("\n " + i + ">  " + salida);
                controladorFromPrincipal.fp.txtArea.setCaretPosition(controladorFromPrincipal.fp.txtArea.getDocument().getLength());
                //System.out.println(i + " " + salida);
                i++;
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}
