package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Proyecto;
import mx.itson.servisoft.entidades.Servicio;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Busqueda_Proyecto extends JFrame {

	private JPanel contentPane;
	String[] headers = {"Id","Nombre", "Programa","Sector","Giro","Empresa","Telefono","Contacto Empresa"};
	DefaultTableModel modelo = new DefaultTableModel(null,headers);
	Proyecto p = new Proyecto();
	private JTable tblProyecto;
	private JTextField txtBusProyecto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda_Proyecto frame = new Busqueda_Proyecto();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void close(){
        GUI a = new GUI();
        a.setLocationRelativeTo(null);
		a.setExtendedState(MAXIMIZED_BOTH);
		a.setVisible(true);
		Busqueda_Proyecto.this.setVisible(false);
        
    }  
	JButton btnRegresar = new JButton("Regresar");
	public void bloqueAMenu(){
		btnRegresar.setVisible(false);
		btnRegresar.setEnabled(false);
	}
	public Busqueda_Proyecto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			close();
			}
		});
		setTitle("Consultar Proyectos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 843, 657);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tblProyecto = new JTable();
		scrollPane_1.setViewportView(tblProyecto);
		
		
		tblProyecto.setModel(modelo);
	
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		llenarTablaProyecto(tblProyecto, modelo, proyectos, "");
		tblProyecto.removeColumn(tblProyecto.getColumnModel().getColumn(0));
		
		JLabel lblSeleccionarProyecto = new JLabel("Buscar:");
		lblSeleccionarProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarProyecto.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
	
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				Busqueda_Proyecto.this.setVisible(false);
			}
		});
		
		txtBusProyecto = new JTextField();
		txtBusProyecto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String cadena = txtBusProyecto.getText();
				List<Proyecto> pro = new ArrayList<Proyecto>();
				llenarTablaProyecto(tblProyecto, modelo, proyectos, cadena);
			}
		});
		txtBusProyecto.setColumns(10);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
								.addComponent(txtBusProyecto, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
								.addComponent(lblSeleccionarProyecto, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))))
					.addGap(71))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblSeleccionarProyecto)
					.addGap(18)
					.addComponent(txtBusProyecto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(btnRegresar)
					.addGap(2))
		);
		
		
		scrollPane_1.setViewportView(tblProyecto);
		
		
		
		
		contentPane.setLayout(gl_contentPane);
	}
	
	

	public void llenarTablaProyecto(JTable tabla, DefaultTableModel modelo, List<Proyecto> proyectos, String cadena)
	{
		proyectos = p.obtenerPorNombre2(cadena); 
		Vector vector = new Vector();
		modelo.setRowCount(0);
		
		for(Proyecto b : proyectos)
		{
			String id = String.valueOf(b.getId());
			String nombre = b.getNombreProyecto();
			String programa= b.getTipoPrograma();
			String sector=b.getSector();
			String giro=b.getGiro();
			String empresa=b.getEmpresa();
			String telefono= b.getTelefono();
			String contacto=b.getContactoEmpresa();
			
			vector.add(id);
			vector.add(nombre);
			vector.add(programa);
			vector.add(sector);
			vector.add(giro);
			vector.add(empresa);
			vector.add(telefono);
			vector.add(contacto);
			
	
			modelo.addRow(vector);
			vector = new Vector();
		}
		
		tabla.setModel(modelo);
		
	}
}
