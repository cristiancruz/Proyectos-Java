package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Servicio;
import mx.itson.servisoft.entidades.crearexcel;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EstadoDeServicio extends JFrame {

	private JPanel contentPane;
	String[] titulos = {"id" , "Periodo" , "Proyecto" , "Empresa" , "Nombre_Alumno", "Apellido_Alumno" , "Carrera" , "Semestre"};
	String[] headers = {"id" , "Nombre" , "Apellido" , "Matricula" , "Carrera", "Semestre" , "Email" , "Plan","Campus", "Telefono"};
	DefaultTableModel modelo= new DefaultTableModel(null, headers);
	JScrollPane scrollPane = new JScrollPane();
	Servicio s = new Servicio();
	Alumno a = new Alumno();
	List<Servicio> servicios = s.buscar();
	List<Alumno> alumnos = a.buscar();
	private JTable tblAlumnos;
	private JTextField txtAnio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadoDeServicio frame = new EstadoDeServicio();
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
		EstadoDeServicio.this.setVisible(false);
        
    }  
	public EstadoDeServicio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			close();
			}
		});
		setTitle("Estado de Servicio");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 940, 732);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTerminarServicios = new JMenuItem("Terminar Servicios");
		mntmTerminarServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarServicio a= new ActualizarServicio();
				a.setLocationRelativeTo(null);
				a.setExtendedState(MAXIMIZED_BOTH);
				a.setVisible(true);
				EstadoDeServicio.this.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmTerminarServicios);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStatusAlumno = new JLabel("Selecione Estado:");
		lblStatusAlumno.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		tblAlumnos = new JTable();
		scrollPane.setViewportView(tblAlumnos);
		tblAlumnos.setModel(modelo);
		 
		tblAlumnos.removeColumn(tblAlumnos.getColumnModel().getColumn(0));
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Activos", "Inactivos"}));
		 JPanel panelBusquedas = new JPanel();
		
		cbxEstado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(cbxEstado.getSelectedItem()=="Inactivos"){
					 panelBusquedas.setVisible(false);
				}else{
					 panelBusquedas.setVisible(true);
				}
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent arg0) {
				modelo.setColumnIdentifiers(headers);
				tblAlumnos.removeColumn(tblAlumnos.getColumnModel().getColumn(0));
				if(cbxEstado.getSelectedIndex() == 0)
				{
					modelo.setRowCount(0);
					List<Integer> activos = alumnosConServicio();
					List<Alumno> alumnosA = new ArrayList<Alumno>();
					@SuppressWarnings("rawtypes")
					Vector row = new Vector();
					for(int ac : activos)
					{
						Alumno alActivo = a.obtenerPorId(ac);
						alumnosA.add(alActivo);
					}
					
				
					for(Alumno als : alumnosA)
					{
						String id = String.valueOf(als.getId());
						String nombre = als.getNombre();
						String apellido = als.getApellido();
						String matricula = als.getMatricula();
						String carrera = als.getCarrera();
						String semestre = als.getSemestre();
						String email = als.getEmail();
						String plan = als.getPlan();
						String campus = als.getCampus();
						String telefono = als.getTelefono();
								
						row.add(id);
						row.add(nombre);
						row.add(apellido);
						row.add(matricula);
						row.add(carrera);
						row.add(semestre);
						row.add(email);
						row.add(plan);
						row.add(campus);
						row.add(telefono);					
						modelo.addRow(row);
						row = new Vector();
					}
					tblAlumnos.setModel(modelo);
					
					
				}else
				{
				   modelo.setRowCount(0);
				   List<Alumno> alumnosI = new ArrayList<Alumno>();
				   List<Integer> inactivos = alumnosSinServicio();
				   
				   for(int ai : inactivos)
				   {
					   Alumno alInactivo = a.obtenerPorId(ai);
					   alumnosI.add(alInactivo);
					  
				   }
				   
				   Vector row = new Vector();
				   
				   for(Alumno als : alumnosI)
					{
						String id = String.valueOf(als.getId());
						String nombre = als.getNombre();
						String apellido = als.getApellido();
						String matricula = als.getMatricula();
						String carrera = als.getCarrera();
						String semestre = als.getSemestre();
						String email = als.getEmail();
						String plan = als.getPlan();
						String campus = als.getCampus();
						String telefono = als.getTelefono();
								
						row.add(id);
						row.add(nombre);
						row.add(apellido);
						row.add(matricula);
						row.add(carrera);
						row.add(semestre);
						row.add(email);
						row.add(plan);
						row.add(campus);
						row.add(telefono);					
						modelo.addRow(row);
						row = new Vector();
					}
					tblAlumnos.setModel(modelo);
				}
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EstadoDeServicio.class.getResource("/itson/mx/servisoft/imagenes/Consultar alumno2.png")));
		label.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				EstadoDeServicio.this.setVisible(false);
			}
		});
		
		JButton btnGeneralExcel = new JButton("Generar Excel");
		btnGeneralExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            crearexcel Excel = new crearexcel();
		            Excel.CreateExcel(modelo);
		            JOptionPane.showMessageDialog(null, "Excel creado");
		        } catch (Exception e) {
		           
		        }
			}
		});
		 
		
		 panelBusquedas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		 GroupLayout gl_contentPane = new GroupLayout(contentPane);
		 gl_contentPane.setHorizontalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(label)
		 			.addGap(22)
		 			.addComponent(lblStatusAlumno)
		 			.addGap(10)
		 			.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 			.addGap(10)
		 			.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		 			.addGap(54)
		 			.addComponent(panelBusquedas, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(107, Short.MAX_VALUE))
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(662)
		 					.addComponent(btnGeneralExcel)
		 					.addGap(30)
		 					.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(22)
		 					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)))
		 			.addGap(28))
		 );
		 gl_contentPane.setVerticalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addContainerGap()
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 						.addComponent(btnBuscar)
		 						.addComponent(label)
		 						.addComponent(lblStatusAlumno)
		 						.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 					.addGap(67))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addComponent(panelBusquedas, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		 					.addGap(18)))
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
		 			.addGap(18)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(btnGeneralExcel)
		 				.addComponent(btnRegresar))
		 			.addContainerGap())
		 );
		 txtAnio = new JTextField();
		 txtAnio.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyTyped(KeyEvent e) {
		 		char numeros = e.getKeyChar();

		        if((numeros<'0' || numeros>'9')) {
		            e.consume();
		        }
		 	}
		 });
		 txtAnio.setToolTipText("Presione enter para buscar");
		 
		 txtAnio.setColumns(10);
		 JComboBox cbxPer = new JComboBox();
		 cbxPer.setModel(new DefaultComboBoxModel(new String[] {"", "Enero-Mayo", "Verano", "Invierno", "Agosto-Diciembre"}));
		 JComboBox cbxSector = new JComboBox();
		 cbxSector.setModel(new DefaultComboBoxModel(new String[] {"", "PUB", "PRIV", "SOC", "INT"}));
		 
		 JComboBox cbxGiro = new JComboBox();
		 cbxGiro.setModel(new DefaultComboBoxModel(new String[] {"", "EDU", "SER", "INDU", "INT", "COMER"}));
		 
		 cbxSector.setSelectedIndex(-1);
		 cbxGiro.setSelectedIndex(-1);
		 cbxPer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				llenarTablaActivos(modelo, txtAnio,cbxPer, cbxSector, cbxGiro, tblAlumnos);
				System.out.println("ey si escucho");
				tblAlumnos.removeColumn(tblAlumnos.getColumnModel().getColumn(0));
			}
		});
		 
		 
		cbxSector.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				llenarTablaActivos(modelo, txtAnio,cbxPer, cbxSector, cbxGiro, tblAlumnos);
				tblAlumnos.removeColumn(tblAlumnos.getColumnModel().getColumn(0));
			}
		}); 
		
		cbxGiro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				llenarTablaActivos(modelo, txtAnio,cbxPer, cbxSector, cbxGiro, tblAlumnos);
				tblAlumnos.removeColumn(tblAlumnos.getColumnModel().getColumn(0));
			}
		});
		 
		txtAnio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				llenarTablaActivos(modelo, txtAnio,cbxPer, cbxSector, cbxGiro, tblAlumnos);
				tblAlumnos.removeColumn(tblAlumnos.getColumnModel().getColumn(0));
			}
		});
		 
		 JLabel lblPeriodo = new JLabel("Periodo");
		 lblPeriodo.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		 
		 JLabel lblSector = new JLabel("Sector");
		 lblSector.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		 
		 JLabel lblGiro = new JLabel("Giro");
		 lblGiro.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		 
		 JLabel lblIngreseAo = new JLabel("Ingrese a\u00F1o:");
		 lblIngreseAo.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		 GroupLayout gl_panelBusquedas = new GroupLayout(panelBusquedas);
		 gl_panelBusquedas.setHorizontalGroup(
		 	gl_panelBusquedas.createParallelGroup(Alignment.LEADING)
		 		.addGroup(Alignment.TRAILING, gl_panelBusquedas.createSequentialGroup()
		 			.addContainerGap(12, Short.MAX_VALUE)
		 			.addGroup(gl_panelBusquedas.createParallelGroup(Alignment.TRAILING)
		 				.addComponent(lblPeriodo)
		 				.addComponent(lblSector, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(lblGiro, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
		 			.addGap(18)
		 			.addGroup(gl_panelBusquedas.createParallelGroup(Alignment.TRAILING, false)
		 				.addComponent(cbxPer, 0, 0, Short.MAX_VALUE)
		 				.addComponent(cbxSector, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 				.addComponent(cbxGiro, 0, 92, Short.MAX_VALUE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_panelBusquedas.createParallelGroup(Alignment.TRAILING, false)
		 				.addComponent(lblIngreseAo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 				.addComponent(txtAnio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
		 			.addContainerGap())
		 );
		 gl_panelBusquedas.setVerticalGroup(
		 	gl_panelBusquedas.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panelBusquedas.createSequentialGroup()
		 			.addComponent(lblIngreseAo)
		 			.addGap(3)
		 			.addGroup(gl_panelBusquedas.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(cbxPer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(txtAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(lblPeriodo))
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addGroup(gl_panelBusquedas.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(cbxSector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(lblSector))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_panelBusquedas.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(cbxGiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(lblGiro))
		 			.addContainerGap(13, Short.MAX_VALUE))
		 );
		 panelBusquedas.setLayout(gl_panelBusquedas);
		 
		 contentPane.setLayout(gl_contentPane);
		 
	}
	
	public List<Integer> alumnosConServicio()
	{
		List<Integer> id = new ArrayList<Integer>();
		int i = 0;
		boolean encontrado = false;
		for(Servicio se : servicios)
		{
			int idAlumno = se.getAlumno().getId();
			
			if(id.isEmpty())
			{
				id.add(idAlumno);
			}
			else if(!id.isEmpty())
			{
				for(int k : id)
				{
					if(k == idAlumno)
					{
						System.out.println("Este id ya existe");
						encontrado = true;
						break;
					}
					else
						encontrado = false;
				}
				if(encontrado == false)
				{
					id.add(idAlumno);
				}
			}
			
		}
		
		return id;
	}
	
	public List<Integer> alumnosSinServicio()
	{
		List<Integer> in = alumnosConServicio();
		List<Integer> out = new ArrayList<Integer>();
		boolean encontrado = false;
		for(Alumno al : alumnos)
		{
			int idAl = al.getId();
			
			for(int j : in)
			{
				if(idAl == j)
				{
					System.out.println("Este id ya existe");
					encontrado = true;
					break;
				}
				else
					encontrado = false;
			}
			
			if(encontrado == false)
				out.add(idAl);
				
		}
		
		return out;
	}
	
	public void llenarTablaActivos(DefaultTableModel modelo, JTextField anio ,JComboBox cbxPer, JComboBox cbxSector, JComboBox cbxGiro, JTable tabla)
	{
		modelo.setRowCount(0);
		//List<Integer> activos = alumnosConServicio();
		String periodo = cbxPer.getSelectedItem().toString() + " " +anio.getText();
		String sector, giro;
		modelo = new DefaultTableModel(null, titulos);
		
		if(cbxSector.getSelectedIndex() == -1)
			sector = "";
		else
			sector = cbxSector.getSelectedItem().toString();
		
		if(cbxGiro.getSelectedIndex() == -1)
			giro = "";
		else
			giro = cbxGiro.getSelectedItem().toString();
		//modelo.removeRow();
		List<Servicio> servicio = s.buscarPorPeriodo(periodo, sector, giro);
		
		if(!servicio.isEmpty())
		{
			Vector vector = new Vector();
			for(Servicio s : servicio)
			{
				String id = String.valueOf(s.getId());
				String per = s.getSemestreRealizacion();
				String nombreProyecto = s.getProyecto().getNombreProyecto();
				String empresa = s.getProyecto().getEmpresa();
				String nombreAlumno = s.getAlumno().getNombre();
				String apellidoAlumno = s.getAlumno().getApellido();
				String carrera = s.getAlumno().getCarrera();
				String semestre = s.getAlumno().getSemestre();
				
				//Filling the model
				vector.add(id);
				vector.add(per);
				vector.add(nombreProyecto);
				vector.add(empresa);
				vector.add(nombreAlumno);
				vector.add(apellidoAlumno);
				vector.add(carrera);
				vector.add(semestre);
				modelo.addRow(vector);
				vector = new Vector();
			}
		}
		tabla.setModel(modelo);

	}
}
