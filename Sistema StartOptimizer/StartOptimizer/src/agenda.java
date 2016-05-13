
import Clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import paneles.panel_usuarios;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumnog
 */
public class agenda extends javax.swing.JFrame {

    /**
     * Creates new form agenda
     */
    public agenda() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        panel_usuarios a = new panel_usuarios();
        a.setSize(this.getSize());
        this.add(a);
        this.setLocationRelativeTo(null);
        txtprov.requestFocus();
        cargarproveedor();
    }
    DefaultTableModel modelo;
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/logo.png"));


        return retValue;
    }
    public void cargarproveedor() {
        this.modelo = new DefaultTableModel(null, new String[]{"Id", "Proveedor", "Telefono"}) {

            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            Statement st2 = cn.createStatement();
            ResultSet re = st2.executeQuery("SELECT * FROM agenda");
            String out[] = new String[3];
            while (re.next()) {
                out[0] = re.getString("Id");
                out[1] = re.getString("proveedor");
                out[2] = re.getString("telefono");
                this.modelo.addRow(out);
            }
            this.tbl_prov.setModel(this.modelo);

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al cargar contactos");
        }

    }
     public void cargarProv() {
        this.modelo = new DefaultTableModel(null, new String[]{"Id", "Proveedor", "Telefono"}) {

            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        this.tbl_prov.setModel(this.modelo);

    }
  public void agregardatos() {
        String provedor = txtprov.getText();
        String tel = txttelef.getText();
        if (!provedor.isEmpty() && !tel.isEmpty()) {
         
            
            try {
          conexion cc = new conexion();
                Connection cn = cc.conectar();
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM agenda WHERE proveedor='" + provedor + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Proveedor en existencia");
                } else if (txttelef.getText().length() == 10) { {

                    st.execute("INSERT INTO agenda (proveedor, telefono) VALUES ( '" + provedor + "','" + tel + "' ) ");
                    JOptionPane.showMessageDialog(null, "Proveedor agregado");
                    cargarproveedor();
                    this.tbl_prov.setModel(this.modelo);
                    this.txtprov.setText("");
                    this.txttelef.setText("");
                    this.txtprov.requestFocus();

                }}else{
                    JOptionPane.showMessageDialog(null,"El telefono tiene que tener 10 Digitos");
                }
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error ");
            }


        } else {
            JOptionPane.showMessageDialog(null, "Es necesario llenar algunos campos");
        }
    }
    public void eliminar_fila() {
        if (this.tbl_prov.getSelectedRow() > -1) {
            int row = this.tbl_prov.getSelectedRow();
            int id = Integer.parseInt(this.tbl_prov.getValueAt(row, 0) + "");
            try {
                int op = new javax.swing.JOptionPane().showOptionDialog(rootPane, "Seguro que quiere eliminar?", "Eliminar", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.YES_NO_OPTION, null, null, "NO");

                if (op == 0) {
                    conexion cc = new conexion();
                    Connection cn = cc.conectar();
                    Statement st = cn.createStatement();
                    st.execute("DELETE FROM agenda WHERE Id=" + id);
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado");
                    this.cargarproveedor();
                }

            } catch (SQLException ex) {
                System.out.println("error sql");
            } finally {
                this.cargarproveedor();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun proveedor");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtprov = new javax.swing.JTextField();
        txttelef = new javax.swing.JTextField();
        btnagre = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prov = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buscar_proveedor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda telefónica");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Provedor:");

        jLabel2.setText("Telefono:");

        txtprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprovActionPerformed(evt);
            }
        });
        txtprov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprovKeyTyped(evt);
            }
        });

        txttelef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefActionPerformed(evt);
            }
        });
        txttelef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefKeyTyped(evt);
            }
        });

        btnagre.setText("Agregar");
        btnagre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagreActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprov, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelef)
                            .addComponent(btnagre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnagre)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        tbl_prov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_prov);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refrescar tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar:");

        buscar_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar_proveedorKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(buscar_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscar_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtprovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprovKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtprovKeyTyped

    private void btnagreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagreActionPerformed
       agregardatos();
    }//GEN-LAST:event_btnagreActionPerformed

    private void txtprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprovActionPerformed
      txtprov.transferFocus();
    }//GEN-LAST:event_txtprovActionPerformed

    private void txttelefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefActionPerformed
      txttelef.transferFocus();
    }//GEN-LAST:event_txttelefActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       eliminar_fila();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txttelefKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefKeyReleased
    
    }//GEN-LAST:event_txttelefKeyReleased

    private void txttelefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefKeyTyped
    char c;
//capturar el caracter digitado
        c = evt.getKeyChar();
        if (c >= '0' && c <= '9') {
        } else {
            evt.consume();
    }
    }//GEN-LAST:event_txttelefKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarproveedor();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscar_proveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar_proveedorKeyReleased
     if (!this.buscar_proveedor.getText().isEmpty()) {
            String gia = this.buscar_proveedor.getText();
            String salida = "";
            for (int i = 0; i < gia.length(); i++) {
                int key = gia.charAt(i);
                if (key == 32 || key >= 65 && key <= 90 || key >= 97 && key <= 122) {
                    salida += gia.charAt(i);
                }
            }
            this.buscar_proveedor.setText(salida.toUpperCase());
            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                Statement st2 = cn.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT * FROM agenda WHERE proveedor LIKE '%" + this.buscar_proveedor.getText() + "%'");
                String out[] = new String[3];
                cargarProv();
                while (rs2.next()) {
                    out[0] = rs2.getString("Id");
                    out[1] = rs2.getString("Proveedor");
                    out[2] = rs2.getString("Telefono");
                    this.modelo.addRow(out);
                }
                this.tbl_prov.setModel(modelo);
            } catch (SQLException ex) {
            }
        } else {
            cargarproveedor();
        }
    }//GEN-LAST:event_buscar_proveedorKeyReleased

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
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agenda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagre;
    private javax.swing.JButton btneliminar;
    private javax.swing.JTextField buscar_proveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_prov;
    private javax.swing.JTextField txtprov;
    private javax.swing.JTextField txttelef;
    // End of variables declaration//GEN-END:variables
}
