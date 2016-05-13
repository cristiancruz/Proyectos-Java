package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
/**
 *
 * @author -_FC_-
 */
public class Reloj extends Thread {
    private JLabel lbl;
    public  Reloj(JLabel lbl) {
        this.lbl = lbl;
    }

    public  void run() {
        while (true) {
            Date hoy = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
            lbl.setText(s.format(hoy));
            try {sleep(1000);

            } catch (Exception ex) {
            }
        }
    }
    
}
