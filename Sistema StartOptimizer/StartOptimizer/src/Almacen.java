
import Clases.crearexcel;
import Clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import paneles.Panel_almacen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import javax.swing.table.DefaultTableModel;
public class Almacen extends javax.swing.JFrame {

    /**
     * Creates new form Almacen
     */
    public Almacen() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Panel_almacen p = new Panel_almacen();
        p.setSize(this.getSize());
        this.add(p);

        cargarproductos();
        productos.requestFocus();
        this.setLocationRelativeTo(null);
    }
     DefaultTableModel modelo_almacen;
     @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/logo.png"));


        return retValue;
    }
    public void cargarproductos() {
        this.modelo_almacen = new DefaultTableModel(null, new String[]{"Id", "Productos", "Cantidad"}) {

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
                this.modelo_almacen.addRow(out);
            }
            this.tbl_almac.setModel(this.modelo_almacen);

        } catch (SQLException ex) {
            System.out.println("error sql al mostrar");
        }

    }
    public void eliminar_fila() {
        if (this.tbl_almac.getSelectedRow() > -1) {
            int row = this.tbl_almac.getSelectedRow();
            int id = Integer.parseInt(this.tbl_almac.getValueAt(row, 0) + "");
            try {
                int op = new javax.swing.JOptionPane().showOptionDialog(rootPane, "Seguro que quiere eliminar?", "Eliminar", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.YES_NO_OPTION, null, null, "NO");

                if (op == 0) {
                    conexion cc = new conexion();
                    Connection cn = cc.conectar();
                    Statement st = cn.createStatement();
                    st.execute("DELETE FROM productos WHERE Id=" + id);
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                    this.cargarproductos();
                }

            } catch (SQLException ex) {
                System.out.println("error sql");
            } finally {
                this.cargarproductos();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun producto");
        }
    }
    public void agregardatos() {
        if(!cantidad.getText().equals("0") && !cantidad.getText().equals("0.0")){
        String produ = productos.getText();
        String canti = cantidad.getText();
        if (!produ.isEmpty() && !canti.isEmpty()) {
            double cantidadddd;
            try {
                cantidadddd = Double.parseDouble(canti);
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE productos='" + produ + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Producto en existencia");
                } else {

                    st.execute("INSERT INTO Productos (productos, cantidad) VALUES ( '" + produ + "','" + cantidadddd + "' ) ");
                    JOptionPane.showMessageDialog(null, "Producto agregado");
                    cargarproductos();
                    this.tbl_almac.setModel(this.modelo_almacen);
                    this.productos.setText("");
                    this.cantidad.setText("");
                    this.productos.requestFocus();

                }
            } catch (SQLException ex) {
                System.out.println("error sql");
            }


        } else {
            JOptionPane.showMessageDialog(null, "Es necesario llenar algunos campos");
        }}else{
            JOptionPane.showMessageDialog(null, "Cantidad sin valor");
    }}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_almac = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        productos = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        btnElimPro = new javax.swing.JButton();
        btnGenerarexcel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        act_tabla = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Almacen");
        setIconImage(getIconImage());
        setResizable(false);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tbl_almac.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_almac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Productos", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tbl_almac);

        jLabel1.setText("Producto:");

        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });
        productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productosKeyTyped(evt);
            }
        });

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });

        jLabel2.setText("Cantidad:");

        btnagregar.setText("Agregar Producto");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnElimPro.setText("Eliminar Producto");
        btnElimPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimProActionPerformed(evt);
            }
        });

        btnGenerarexcel.setText("Generar Excel");
        btnGenerarexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarexcelActionPerformed(evt);
            }
        });

        jLabel6.setText("       Agregar Productos:");

        act_tabla.setText("Refrescar tabla");
        act_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                act_tablaActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar  producto");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("                             \"Registros\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGenerarexcel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(btnElimPro, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(productos, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                            .addComponent(act_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(btnagregar)
                        .addGap(20, 20, 20)
                        .addComponent(btnElimPro)
                        .addGap(19, 19, 19)
                        .addComponent(act_tabla)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarexcel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnactualizar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnElimProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimProActionPerformed
          eliminar_fila();
    }//GEN-LAST:event_btnElimProActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        agregardatos();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
       productos.transferFocus();
    }//GEN-LAST:event_productosActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        cantidad.transferFocus();
    }//GEN-LAST:event_cantidadActionPerformed

    private void productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_productosKeyPressed

    private void productosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productosKeyTyped
 char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_productosKeyTyped

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
      
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && cantidad.getText().contains(".")) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidadKeyTyped

    private void btnGenerarexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarexcelActionPerformed
        try {
            crearexcel Excel = new crearexcel();
            Excel.CreateExcel(modelo_almacen);
            JOptionPane.showMessageDialog(null, "Excel creado");
        } catch (Exception e) {
           
        }

    }//GEN-LAST:event_btnGenerarexcelActionPerformed

    private void act_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_act_tablaActionPerformed
        cargarproductos();
    }//GEN-LAST:event_act_tablaActionPerformed

    private void productosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productosKeyReleased

    }//GEN-LAST:event_productosKeyReleased

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       Actualizar a= new Actualizar();
       a.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnactualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Almacen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton act_tabla;
    private javax.swing.JButton btnElimPro;
    private javax.swing.JButton btnGenerarexcel;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productos;
    private javax.swing.JTable tbl_almac;
    // End of variables declaration//GEN-END:variables
}
