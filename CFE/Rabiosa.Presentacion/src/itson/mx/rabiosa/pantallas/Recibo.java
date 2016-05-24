package itson.mx.rabiosa.pantallas;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import mx.itson.rabiosa.entidades.Cliente;
import mx.itson.rabiosa.entidades.Configuracion;
import mx.itson.rabiosa.entidades.ConsumoMensual;

import javax.swing.JLayeredPane;
import javax.swing.border.CompoundBorder;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;



public class Recibo extends JFrame {

	public JPanel contentPane;
	public JTextField txtKwConsumidos;
	double subTotal = 0;
	double total = 0;
	double Kilowatts, PrecioKwH, sIva, sDap;
	DefaultTableModel modelo= new DefaultTableModel();
	JTable tab = new JTable();
	Configuracion conf = new Configuracion();
	
	Date date = new Date();
	Calendar cal = Calendar.getInstance(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recibo frame = new Recibo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Recibo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(128, 11, 84, 14);
		contentPane.add(lblClientes);
		
		JScrollPane sClientes = new JScrollPane();
		sClientes.setBounds(20, 36, 277, 179);
		contentPane.add(sClientes);
				
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(321, 51, 52, 14);
		contentPane.add(lblNombre);
		
		JLabel lb_nCliente = new JLabel("----------");
		lb_nCliente.setBounds(379, 51, 151, 14);
		contentPane.add(lb_nCliente);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "KWH Consumidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		layeredPane.setBounds(20, 245, 319, 69);
		contentPane.add(layeredPane);
		
		txtKwConsumidos = new JTextField();
		txtKwConsumidos.setBounds(33, 28, 160, 20);
		layeredPane.add(txtKwConsumidos);
		txtKwConsumidos.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(203, 27, 89, 23);
		layeredPane.add(btnCalcular);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Recibo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_1.setBounds(20, 342, 342, 150);
		contentPane.add(layeredPane_1);
		
		JLabel lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setBounds(17, 35, 63, 14);
		layeredPane_1.add(lblSubtotal);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(34, 112, 46, 14);
		layeredPane_1.add(lblTotal);
		
		JLabel lb_subTotal = new JLabel("0.0");
		lb_subTotal.setBounds(96, 35, 86, 14);
		layeredPane_1.add(lb_subTotal);
		
		JLabel lb_total = new JLabel("0.0");
		lb_total.setBounds(96, 112, 89, 14);
		layeredPane_1.add(lb_total);
		
		JLabel lb_subIva = new JLabel("0.0");
		lb_subIva.setBounds(96, 60, 86, 14);
		layeredPane_1.add(lb_subIva);
		
		JLabel lb_subDap = new JLabel("0.0");
		lb_subDap.setBounds(96, 85, 86, 14);
		layeredPane_1.add(lb_subDap);
		
		JLabel label = new JLabel("IVA:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(40, 60, 40, 14);
		layeredPane_1.add(label);
		
		JLabel label_1 = new JLabel("DAP:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(40, 85, 40, 14);
		layeredPane_1.add(label_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(379, 401, 127, 23);
		contentPane.add(btnGuardar);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Porcentaje de Importes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_2.setBounds(321, 88, 209, 127);
		contentPane.add(layeredPane_2);
		
		JLabel lb_iva = new JLabel("0.0");
		lb_iva.setBounds(105, 33, 46, 14);
		layeredPane_2.add(lb_iva);
				
		JLabel lblIva = new JLabel("IVA:");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setBounds(55, 33, 40, 14);
		layeredPane_2.add(lblIva);
		
		JLabel lblPda = new JLabel("DAP:");
		lblPda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPda.setBounds(55, 58, 40, 14);
		layeredPane_2.add(lblPda);
		
		JLabel lb_dap = new JLabel("0.0");
		lb_dap.setBounds(105, 58, 46, 14);
		layeredPane_2.add(lb_dap);
		
		JLabel lb_precio = new JLabel("0.0");
		lb_precio.setBounds(105, 83, 46, 14);
		layeredPane_2.add(lb_precio);
				
		JLabel lblNewLabel = new JLabel("Precio Kw:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(29, 83, 66, 14);
		layeredPane_2.add(lblNewLabel);
		
		//llenado tabla clientes
		//--------------------------------------//
		Cliente cl = new Cliente();		
		List<Cliente> lcl = cl.listaClientes();
		String Titulos[] = {"ID", "Nombre", "Apellido"};
		 modelo = new DefaultTableModel(new Object[0][0], Titulos);	
		for(int i=0; i<lcl.size(); i++) {
			Object[] o = new Object[3];
	        o[0] = lcl.get(i).getId();
	        o[1] = lcl.get(i).getNombre();
	        o[2] = lcl.get(i).getApellido();
	        modelo.addRow(o);
		}		
		tab.setModel(modelo);
		sClientes.setViewportView(tab);
		
		//--------------------------------------//
		//llenado configuracion
		List<Configuracion> lcon = conf.getConfiguracion();	
		lb_iva.setText(String.valueOf(lcon.get(0).getIva()));
		lb_dap.setText(String.valueOf(lcon.get(0).getDap()));
		lb_precio.setText(String.valueOf(lcon.get(0).getPrecioKwHora()));
		//--------------------------------------//	
		JButton btnRegresar = new JButton(" Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui a= new Gui();
				a.setVisible(true);
				Recibo.this.setVisible(false);
			}
		});
		btnRegresar.setBounds(379, 436, 127, 23);
		contentPane.add(btnRegresar);
		
	
		tab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//manda el cliente selecionado al label de nombre cliente
				if (tab.getSelectedRow() != -1) {
					lb_nCliente.setText(tab.getValueAt(tab.getSelectedRow(), 1).toString()+" "+tab.getValueAt(tab.getSelectedRow(), 2));
				}
			}
		});
		
		txtKwConsumidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
		        if (!(c>='0' && c<='9') && c!='.') {
		            evt.consume();
		        }
		        if (c=='.' && txtKwConsumidos.getText().contains(".")) {
		        	evt.consume();
		        }
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtKwConsumidos.getText().equals("")) {
					Kilowatts = Double.valueOf(txtKwConsumidos.getText()); 
					PrecioKwH = lcon.get(0).getPrecioKwHora();
					
					subTotal = Kilowatts * PrecioKwH;
					sIva = subTotal * lcon.get(0).getIva();
					sDap = subTotal * lcon.get(0).getDap();
					total = subTotal + sIva + sDap;
					lb_subTotal.setText(String.valueOf(subTotal));
					lb_subIva.setText(String.valueOf(sIva));
					lb_subDap.setText(String.valueOf(sDap));
					lb_total.setText(String.valueOf(total));
				}else{
					JOptionPane.showMessageDialog(null, "Llene el campo de kw consumidos");
				}
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validacion para guardar 
				if (lb_total.getText() != "0.0" && tab.getSelectedRow() != -1) {
					ConsumoMensual con = new ConsumoMensual();
					cal.setTime(date);
					int mes = cal.get(Calendar.MONTH)+1;
					int year = cal.get(Calendar.YEAR);
					int idC = lcl.get(tab.getSelectedRow()).getId();
					String nameClient=lb_nCliente.getText();
					//guardadp
					con.guardar(idC,nameClient, Kilowatts, mes, year, 0, subTotal, total);				
					//crear pdf----------------------------------------------------------------
					Document document = new Document();

				        try {
				            PdfWriter.getInstance(document,new FileOutputStream("Recibo.pdf"));

				            document.open();
				            
				            try{
				                //Obtenemos la instancia de la imagen
				                Image imagen = Image.getInstance("cfe.png");
				                //Alineamos la imagen al centro
				                imagen.setAlignment(Image.ALIGN_CENTER);			                
				                //Agregamos la imagen al documento
				                document.add(imagen);      
				              }catch(IOException | DocumentException  ex){
				                ex.getMessage();
				              }
				            Calendar cal = Calendar.getInstance();
					        Date fecha = new Date( cal.getTimeInMillis() );
					        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				        		document.add(new Paragraph("RECIBO DE LUZ CFE"));
				        		document.add(new Paragraph("Fecha: "+formato.format(fecha)));
						        document.add(new Paragraph("Nombre: "+lb_nCliente.getText()));
						        document.add(new Paragraph("Subtotal: "+lb_subTotal.getText()));
						        document.add(new Paragraph("Iva: "+lb_subIva.getText()));
						        document.add(new Paragraph("Dap: "+lb_subDap.getText()));
						        document.add(new Paragraph("Total: "+lb_total.getText()));
						        try{
					                //Obtenemos la instancia de la imagen
					                Image imagen2 = Image.getInstance("qr.png");
					                //Alineamos la imagen al centro
					                imagen2.setAlignment(Image.ALIGN_CENTER);
					                
					                //Agregamos la imagen al documento
					                document.add(imagen2);      
					              }catch(IOException | DocumentException  ex){
					                ex.getMessage();
					              }
						        try{
					                //Obtenemos la instancia de la imagen
					                Image imagen3 = Image.getInstance("cbarras.gif");
					                //Alineamos la imagen al centro
					                imagen3.setAlignment(Image.ALIGN_CENTER);
					                //Agregamos la imagen al documento
					                document.add(imagen3);      
					              }catch(IOException | DocumentException  ex){
					                ex.getMessage();
					              }
						        document.close(); 
						    
				        } catch (DocumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        JOptionPane.showMessageDialog(null, "Recibo guardado!");
			        lb_nCliente.setText("");
			        lb_subTotal.setText("");
			        lb_subIva.setText("");
			        lb_subDap.setText("");
			        lb_total.setText("");
			        txtKwConsumidos.setText("");
			        //abrir pdf
			        String pdfFile="Recibo.pdf";
			        if (pdfFile.toString().endsWith(".pdf")) {
			                        try {
										Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + pdfFile);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
			                    } 
			    
				}else{
					JOptionPane.showMessageDialog(null, "Selecione un cliente para operacion");
				}
			}
		});
	}
}
