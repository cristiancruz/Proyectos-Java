
import Clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import paneles.panel_usuarios;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Actualizar.java
 *
 * Created on 7/04/2014, 11:21:52 AM
 */

/**
 *
 * @author alumnog
 */
public class Actualizar1 extends javax.swing.JFrame {

    /** Creates new form Actualizar */
    DefaultTableModel modelo;

    public Actualizar1() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        panel_usuarios a = new panel_usuarios();
        a.setSize(this.getSize());
        this.add(a);
        this.setLocationRelativeTo(null);
        buscar_produc.requestFocus();
        cargarproductos();
    }@Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/logo.png"));


        return retValue;
    }
 public void extraer() {
        int fila = tbl_p.getSelectedRow();
        if (fila == -1) {
       //     JOptionPane.showMessageDialog(rootPane, "no se ha seleccionado ninguna fila");
        } else {
            String producto = (String) tbl_p.getValueAt(fila, 1);
            String cantidad = (String) tbl_p.getValueAt(fila, 2);
         
            
            prod.setText(producto);
            cant.setText(cantidad);
     
        } }
    public void cargarProd() {
        this.modelo = new DefaultTableModel(null, new String[]{"Id", "Productos", "Cantidad"}) {

            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        this.tbl_p.setModel(this.modelo);

    }

    public void cargarproductos() {
        this.modelo = new DefaultTableModel(null, new String[]{"Id", "Productos", "Cantidad"}) {

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
            ResultSet re = st2.executeQuery("SELECT * FROM Productos");
            String out[] = new String[3];
            while (re.next()) {
                out[0] = re.getString("Id");
                out[1] = re.getString("Productos");
                out[2] = re.getString("Cantidad");
                this.modelo.addRow(out);
            }
            tbl_p.setAutoCreateRowSorter(true);
            this.tbl_p.setModel(this.modelo);

        } catch (SQLException ex) {
            System.out.println("error sql al mostrar");
        }

    }

    public void actualizar_datos() {
        if(!cant.getText().equals("0") && !cant.getText().equals("0.0")){
        String produ = prod.getText();
        String canti = cant.getText();
        if (!produ.isEmpty() && !canti.isEmpty()) {
            double cantidadddd;
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            try {
                cantidadddd = Double.parseDouble(canti);
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE productos='" + produ + "'");
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Producto sin existencia");
                    prod.setText("");
                    cant.setText("");

                } else {
                    if (this.tbl_p.getSelectedRow() > -1) {
                        int row = this.tbl_p.getSelectedRow();
                        int id = Integer.parseInt(this.tbl_p.getValueAt(row, 0) + "");
                        Statement stt = cn.createStatement();
                        ResultSet rss = stt.executeQuery("SELECT * FROM productos WHERE productos='" + produ + "'");
                        if (rss.next()) {
                            st.execute("DELETE FROM productos WHERE Id=" + id);

                            st.execute("INSERT INTO Productos (productos, cantidad) VALUES ( '" + produ + "','" + cantidadddd + "' ) ");
                            JOptionPane.showMessageDialog(null, "Producto Actualizado");
                            cargarproductos();
                            this.tbl_p.setModel(this.modelo);
                            this.prod.setText("");
                            this.cant.setText("");
                            this.buscar_produc.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "1.-Seleccionar Producto que desea modificar\n2.-Guardar cambios de nuevo");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario llenar algunos campos");
        }}else{
            JOptionPane.showMessageDialog(null, "Cantidad sin valor");
    }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_p = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscar_produc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prod = new javax.swing.JTextField();
        cant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btncambios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Actualizar");
        setIconImage(getIconImage());

        tbl_p.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_p);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        buscar_produc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar_producKeyReleased(evt);
            }
        });

        jLabel5.setText("Actualizar Cantidades:");

        jLabel3.setText("Producto:");

        prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodActionPerformed(evt);
            }
        });
        prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prodKeyTyped(evt);
            }
        });

        cant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantActionPerformed(evt);
            }
        });
        cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantKeyTyped(evt);
            }
        });

        jLabel4.setText("Cantidad:");

        btncambios.setText("Guardar cambios");
        btncambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiosActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(prod, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cant)
                                    .addComponent(btncambios, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(buscar_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(buscar_produc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncambios)
                                .addGap(102, 102, 102)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_producKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar_producKeyReleased
        if (!this.buscar_produc.getText().isEmpty()) {
            String gia = this.buscar_produc.getText();
            String salida = "";
            for (int i = 0; i < gia.length(); i++) {
                int key = gia.charAt(i);
                if (key == 32 || key >= 65 && key <= 90 || key >= 97 && key <= 122) {
                    salida += gia.charAt(i);
                }
            }
            this.buscar_produc.setText(salida.toUpperCase());
            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                Statement st2 = cn.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT * FROM productos WHERE productos LIKE '%" + this.buscar_produc.getText() + "%'");
                String out[] = new String[3];
                cargarProd();
                while (rs2.next()) {
                    out[0] = rs2.getString("Id");
                    out[1] = rs2.getString("Productos");
                    out[2] = rs2.getString("Cantidad");
                    this.modelo.addRow(out);
                }
                this.tbl_p.setModel(modelo);
            } catch (SQLException ex) {
            }
        } else {
            // this.cargarProd();
            cargarproductos();
        }
    }//GEN-LAST:event_buscar_producKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Almacen_Invitado s= new Almacen_Invitado();
      s.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodActionPerformed
        prod.transferFocus();
}//GEN-LAST:event_prodActionPerformed

    private void prodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodKeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_prodKeyPressed

    private void prodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodKeyReleased

}//GEN-LAST:event_prodKeyReleased

    private void prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodKeyTyped
      char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
}//GEN-LAST:event_prodKeyTyped

    private void cantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantActionPerformed
        cant.transferFocus();
}//GEN-LAST:event_cantActionPerformed

    private void cantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && cant.getText().contains(".")) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.')) {
            evt.consume();
        }
}//GEN-LAST:event_cantKeyTyped

    private void btncambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiosActionPerformed
        actualizar_datos();
}//GEN-LAST:event_btncambiosActionPerformed

    private void tbl_pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pMouseClicked
      extraer();
    }//GEN-LAST:event_tbl_pMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizar1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncambios;
    private javax.swing.JTextField buscar_produc;
    private javax.swing.JTextField cant;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prod;
    private javax.swing.JTable tbl_p;
    // End of variables declaration//GEN-END:variables

}
