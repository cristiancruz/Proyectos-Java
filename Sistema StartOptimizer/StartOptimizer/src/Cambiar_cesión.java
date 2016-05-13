import Clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import paneles.Panel_login;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import javax.swing.WindowConstants;

public class Cambiar_cesión extends javax.swing.JFrame {



    public Cambiar_cesión() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Panel_login p = new Panel_login();
        p.setSize(this.getSize());
        this.add(p);

        this.setLocationRelativeTo(null);
        btnusuario.requestFocus();
        btnentrar.addKeyListener(new PresionarTecla());
    }
public class PresionarTecla extends KeyAdapter {
      public void keyPressed(KeyEvent ke) {
          if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
              btnentrarActionPerformed(null);
          }
      }
}
@Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/logo.png"));


        return retValue;
    }
public void acceso(){
        if (!this.btnusuario.getText().isEmpty()) {
            if (!(String.valueOf(this.btnpass.getPassword())).isEmpty()) {
                String user = this.btnusuario.getText(), pass = String.valueOf(this.btnpass.getPassword());
                try {
                    conexion cc = new conexion();
                    Connection cn = cc.conectar();
                    Statement st2 = cn.createStatement();
                    ResultSet re = st2.executeQuery("SELECT * FROM usuario WHERE usuario='" + user + "' AND password='" + pass + "'");
                    if (re.next()) {
                        GUI m = new GUI();
                        m.setVisible(true);
                        m.setLocationRelativeTo(null);
                        this.setVisible(false);
                  JOptionPane.showMessageDialog(null, "Bienvenido al sistema "+"'"+btnusuario.getText()+"'");
                        if (re.getInt("tipoUsuario") == 1) {//0- ADMIN 1-invitado
                            m.cargarUsuario();                          
                        }
                    } else {                     
                        new javax.swing.JOptionPane().showMessageDialog(null, "Usuario o contraseña\nIncorrectos", null, JOptionPane.ERROR_MESSAGE);
                       
                    }

                } catch (SQLException ex) {
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnentrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnusuario = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        btnpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambio de cesión ");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        btnentrar.setText("Entrar");
        btnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario: ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contraseña.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        btnusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuarioActionPerformed(evt);
            }
        });
        btnusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnusuarioKeyTyped(evt);
            }
        });

        btncancelar.setText("Salir");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpassActionPerformed(evt);
            }
        });
        btnpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnpassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btnusuario)
                    .addComponent(btnentrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpass))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(btnusuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnpass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuarioActionPerformed
        btnusuario.transferFocus();
}//GEN-LAST:event_btnusuarioActionPerformed

    private void btnpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnpassKeyPressed
        PresionarTecla y = new PresionarTecla();
        y.keyPressed(evt);
}//GEN-LAST:event_btnpassKeyPressed

    private void btnpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpassActionPerformed
        btnpass.transferFocus();
}//GEN-LAST:event_btnpassActionPerformed

    private void btnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentrarActionPerformed
      acceso();
}//GEN-LAST:event_btnentrarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
  int op = new javax.swing.JOptionPane().showOptionDialog(rootPane, "Seguro que desea salir del sistema?", "Salir", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.YES_NO_OPTION, null, null, "NO");
                if (op == 0) {
                JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                System.exit(0);
                }
}//GEN-LAST:event_btncancelarActionPerformed

    private void btnusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnusuarioKeyTyped
     char c;
        c = evt.getKeyChar();
        if ((c < 'a' || c > 'z')) {
            evt.consume();
        }
    }//GEN-LAST:event_btnusuarioKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnentrar;
    private javax.swing.JPasswordField btnpass;
    private javax.swing.JTextField btnusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
