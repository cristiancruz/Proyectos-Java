package itson.mx.rabiosa.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.crypto.spec.IvParameterSpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import mx.itson.rabiosa.entidades.Configuracion;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Configurar extends JFrame {

	private JPanel contentPane;
	Configuracion configuracion= new Configuracion();
	private JTable table;
	private JTextField txtIva;
	private JTextField txtDap;
	private JTextField txtPrecioKwHora;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configurar frame = new Configurar();
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
//Metodo para extraer la informacion de la tabla configuracion de la bd
	public String[] info()
	{
		String[] datos = new String[4];
		int i = 0;
			for(Configuracion s: configuracion.getConfiguracion())
			{
				
				String id = String.valueOf(s.getId());
				String iva =String.valueOf(s.getIva());
				String dap =String.valueOf(s.getDap());
				String precioKwHora = String.valueOf(s.getPrecioKwHora());
				datos[0] = id;
				datos[1] = iva;
				datos[2] = dap;
				datos[3] = precioKwHora;			
				i++;
			}
		return datos;
	}
	//metodo para pasar el contenido guardado en el metodo info() en mi modelo de tabla
	public void LlenadoTabla(JTable tabla)
	{		
		String[]contenido= info();
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Id");
		 modelo.addColumn("Iva");
		 modelo.addColumn("Dap");
		 modelo.addColumn("$ kW");
		modelo.addRow(contenido);
		tabla.setModel(modelo);	
	}
	
	public Configurar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaClientes = new JLabel(" Lista Configuracion");
		lblListaClientes.setBounds(10, 11, 149, 14);
		contentPane.add(lblListaClientes);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui a = new Gui();
				a.setVisible(true);
				Configurar.this.setVisible(false);
			}
		});
		btnRegresar.setBounds(353, 411, 89, 23);
		contentPane.add(btnRegresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int fila = table.getSelectedRow();
			//Mandar selecion de tabla a texfield para su posterior edicion
			        if (fila == -1) {
			       //    si no selecciona
			        } else {
			            String Iva = (String) table.getValueAt(fila, 1);
			            String Dap = (String) table.getValueAt(fila, 2);
			            String precioKw = (String) table.getValueAt(fila,3);
			       
			            txtIva.setText(Iva);
			            txtDap.setText(Dap);
			            txtPrecioKwHora.setText(precioKw);
			     
			        }
			}
		});
		scrollPane.setBounds(10, 57, 432, 76);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	//desde aqui arranca el llenado de la tabla al abrir el frame
	LlenadoTabla(table);
	
	JLabel lblIva = new JLabel("Iva:");
	lblIva.setBounds(60, 169, 46, 14);
	contentPane.add(lblIva);
	
	JLabel lblDap = new JLabel("Dap:");
	lblDap.setBounds(60, 207, 25, 14);
	contentPane.add(lblDap);
	
	JLabel lblPrecioKwHora = new JLabel(" Precio Kw Hora:");
	lblPrecioKwHora.setBounds(10, 254, 89, 14);
	contentPane.add(lblPrecioKwHora);
	
	txtIva = new JTextField();
	txtIva.setBounds(110, 166, 119, 20);
	contentPane.add(txtIva);
	txtIva.setColumns(10);
	
	txtDap = new JTextField();
	txtDap.setColumns(10);
	txtDap.setBounds(110, 204, 119, 20);
	contentPane.add(txtDap);
	
	txtPrecioKwHora = new JTextField();
	txtPrecioKwHora.setColumns(10);
	txtPrecioKwHora.setBounds(110, 251, 119, 20);
	contentPane.add(txtPrecioKwHora);
	
	JButton btnNewButton = new JButton("Actualizar");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (!txtIva.getText().isEmpty() && !txtDap.getText().isEmpty() && !txtPrecioKwHora.getText().isEmpty()){
				double iva=Double.parseDouble(txtIva.getText());
				double dap=Double.parseDouble(txtDap.getText());
				double precio=Double.parseDouble(txtPrecioKwHora.getText());
				
				/*le asignamos 1 como id ya que sera el unico registro que se actualizara ya que
				este se utiliza solo jalando sus datos  los cuales se manipulan para las
				operaciones para la creacion del recibo*/
				
				configuracion.actualizar(1,iva, dap, precio);
					
				JOptionPane.showMessageDialog(null, "Datos actualizados");
				LlenadoTabla(table);//al actualizar un dato volvemos a llenar la tabla con la info de la bd
				}else{
					
					JOptionPane.showMessageDialog(null, "Llene los campos");
				}
				
		}
	});
	btnNewButton.setBounds(110, 297, 119, 23);
	contentPane.add(btnNewButton);
		
		
	}
}
