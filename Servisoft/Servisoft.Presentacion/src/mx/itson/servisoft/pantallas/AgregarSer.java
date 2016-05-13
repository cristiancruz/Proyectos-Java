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

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgregarSer extends JFrame {

	private JPanel contentPane;
	private JTextField txtDuracion;
	private JTextField txtHorario;
	private JTextField txtHoras;
	private JTable tblAlumno;
	String[] titulos = {"Id" , "Nombre","Apellido","Matricula"};
	String[] headers = {"Id", "Nombre"};
	DefaultTableModel modelo = new DefaultTableModel(null,titulos);
	DefaultTableModel modelo2 = new DefaultTableModel(null,headers);
	private JTextField txtBuscar;
	Alumno a = new Alumno();
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
					AgregarSer frame = new AgregarSer();
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
		Object [] opciones ={"Aceptar","Cancelar"}; 
		int eleccion = JOptionPane.showOptionDialog(null,"En realidad desea cerrar el sistema","Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar"); 
		if (eleccion == JOptionPane.YES_OPTION) {
			new Control().cerrarApp(); 
		}   
    }  
	JButton btnRegresar = new JButton("Regresar");
	JMenu mnArchivo = new JMenu("Archivo");
	public void bloqueAMenu(){
		btnRegresar.setVisible(false);
		btnRegresar.setEnabled(false);
		mnArchivo.setEnabled(true);
	}
	public AgregarSer() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		setTitle("Registrar Servicio");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1428, 657);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		setJMenuBar(menuBar);
		
	
		mnArchivo.setEnabled(false);
		menuBar.add(mnArchivo);
		
		JMenuItem mntmRegistrarProyecto = new JMenuItem("Registrar Proyecto");
		mntmRegistrarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AgregarProyectos a= new AgregarProyectos();
				a.setLocationRelativeTo(null);
				a.ocultarOption();
				a.setVisible(true);
				AgregarSer.this.setVisible(false);
			}
		});
		mnArchivo.add(mntmRegistrarProyecto);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		tblAlumno = new JTable();
		tblAlumno.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		tblAlumno.setFillsViewportHeight(true);
		tblAlumno.setAutoCreateRowSorter(true);
		tblAlumno.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tblAlumno.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setViewportView(tblAlumno);
		tblAlumno.setModel(modelo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tblProyecto = new JTable();
		scrollPane_1.setViewportView(tblProyecto);
		
		
		tblProyecto.setModel(modelo2);
	
		List<Alumno> alumnos = new ArrayList<Alumno>();
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		llenarTabla(tblAlumno, modelo, alumnos, "");
		llenarTablaProyecto(tblProyecto, modelo2, proyectos, "");
		tblAlumno.removeColumn(tblAlumno.getColumnModel().getColumn(0));
		tblProyecto.removeColumn(tblProyecto.getColumnModel().getColumn(0));
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'0' || numeros>'9')) {
		            e.consume();
		        }
			}
		});
		txtHoras.setColumns(10);
		txtHoras.setBounds(186, 234, 278, 20);
		panel.add(txtHoras);
		
		JLabel lblHorasPorServicio = new JLabel("Horas por Servicio:");
		lblHorasPorServicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorasPorServicio.setFont(new Font("Arial", Font.BOLD, 14));
		lblHorasPorServicio.setBounds(10, 226, 166, 35);
		panel.add(lblHorasPorServicio);
		
		JComboBox cbxStatus = new JComboBox();
		cbxStatus.setModel(new DefaultComboBoxModel(new String[] {"EN PROCESO", "TERMINADO"}));
		cbxStatus.setBounds(186, 276, 138, 20);
		panel.add(cbxStatus);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Arial", Font.BOLD, 14));
		lblEstado.setBounds(10, 268, 166, 35);
		panel.add(lblEstado);
		
		JComboBox cbxSemestre = new JComboBox();
		cbxSemestre.setModel(new DefaultComboBoxModel(new String[] {"Enero-Mayo", "Verano", "Invierno", "Agosto-Diciembre"}));
		cbxSemestre.setBounds(186, 52, 278, 20);
		panel.add(cbxSemestre);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAo.setFont(new Font("Arial", Font.BOLD, 14));
		lblAo.setBounds(10, 81, 166, 35);
		panel.add(lblAo);
		
		JComboBox cbxAnio = new JComboBox();
		cbxAnio.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cbxAnio.setBounds(186, 83, 278, 20);
		panel.add(cbxAnio);
		
		JLabel lblSemestreRealizacion = new JLabel("Semestre Realizacion:");
		lblSemestreRealizacion.setBounds(10, 44, 166, 35);
		panel.add(lblSemestreRealizacion);
		lblSemestreRealizacion.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(10, 127, 166, 35);
		panel.add(lblDuracion);
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setFont(new Font("Arial", Font.BOLD, 14));
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(186, 135, 278, 20);
		panel.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setBounds(186, 173, 278, 20);
		panel.add(txtHorario);
		txtHorario.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 165, 166, 35);
		panel.add(lblHorario);
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel label_4 = new JLabel("Ingresar Datos");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		JLabel lblSeleccionarAlumno = new JLabel("Seleccionar Alumno");
		lblSeleccionarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarAlumno.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		JLabel lblSeleccionarProyecto = new JLabel("Seleccionar Proyecto");
		lblSeleccionarProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarProyecto.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
	
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				AgregarSer.this.setVisible(false);
			}
		});
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String nombre = txtBuscar.getText();
				List<Alumno> q = new ArrayList<Alumno>();
				llenarTabla(tblAlumno, modelo, alumnos, nombre);
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'a' || numeros>'z')) {
		            e.consume();
		        }
			}
		});
		txtBuscar.setColumns(10);
		
		txtBusProyecto = new JTextField();
		txtBusProyecto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String cadena = txtBusProyecto.getText();
				List<Proyecto> pro = new ArrayList<Proyecto>();
				llenarTablaProyecto(tblProyecto, modelo2, proyectos, cadena);
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'a' || numeros>'z')) {
		            e.consume();
		        }
			}
		});
		txtBusProyecto.setColumns(10);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtBuscar, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
								.addComponent(lblSeleccionarAlumno, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
								.addComponent(txtBusProyecto, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
								.addComponent(lblSeleccionarProyecto, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(lblSeleccionarAlumno)
						.addComponent(lblSeleccionarProyecto))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(txtBusProyecto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnRegresar)
					.addContainerGap())
		);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(186, 343, 278, 23);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( cbxSemestre.getSelectedIndex() > -1 && cbxAnio.getSelectedIndex() > -1 && cbxStatus.getSelectedIndex() > -1 && !txtDuracion.getText().isEmpty() && !txtHorario.getText().isEmpty() && !txtHoras.getText().isEmpty() && tblAlumno.getSelectedRows().length > 0 && tblProyecto.getSelectedRows().length > 0){
					String semestreRealizacion = cbxSemestre.getSelectedItem().toString();
					String anio = cbxAnio.getSelectedItem().toString();
					String duracion = txtDuracion.getText();
					String horario = txtHorario.getText();
					int horas = Integer.parseInt(txtHoras.getText());
					String status = cbxStatus.getSelectedItem().toString();
					boolean estatus;
					
					if(status == "TERMINADO")
						estatus = true;
					else
						estatus = false;
					
					
					int fila = tblAlumno.getSelectedRow();
					int row = tblProyecto.getSelectedRow();
					int idAlumno = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
					int idProyecto = Integer.parseInt(modelo2.getValueAt(row, 0).toString());
					
				
					
					Alumno alumno = a.obtenerPorId(idAlumno);
					Proyecto proyecto = p.obtenerPorId(idProyecto);
					
					Servicio servicio = new Servicio();
					if(servicio.guardar(semestreRealizacion+" "+anio, duracion, horario, horas, estatus, alumno, proyecto))
						JOptionPane.showMessageDialog(null, "Exito");
					txtDuracion.setText("");
					txtHorario.setText("");
					txtHoras.setText("");

				}else{
					JOptionPane.showMessageDialog(null, "Falta llenar o selecionar algun campo");
				}
				
				
			}
		});
		
		
		scrollPane_1.setViewportView(tblProyecto);
		
		
		
		
		contentPane.setLayout(gl_contentPane);
	}
	public float getTblAlumnoAlignmentX() {
		return tblAlumno.getAlignmentX();
	}
	public void setTblAlumnoAlignmentX(float alignmentX) {
		tblAlumno.setAlignmentX(alignmentX);
	}
	
	public void llenarTabla(JTable tabla, DefaultTableModel modelo, List<Alumno> alumnos, String cadena)
	{
		alumnos = a.buscarPorNombre(cadena); 
		Vector vector = new Vector();
		modelo.setRowCount(0);
		
		for(Alumno b : alumnos)
		{
			String id = String.valueOf(b.getId());
			String nombre = b.getNombre();
			String apellido = b.getApellido();
			String matricula = b.getMatricula();
			
			vector.add(id);
			vector.add(nombre);
			vector.add(apellido);
			vector.add(matricula);
			
			modelo.addRow(vector);
			
			vector = new Vector();
		}
		
		tabla.setModel(modelo);
		
	}
	public void llenarTablaProyecto(JTable tabla, DefaultTableModel modelo, List<Proyecto> proyectos, String cadena)
	{
		proyectos = p.obtenerPorNombre(cadena); 
		Vector vector = new Vector();
		modelo.setRowCount(0);
		//
		for(Proyecto b : proyectos)
		{
			String id = String.valueOf(b.getId());
			String nombre = b.getNombreProyecto();
			
			vector.add(id);
			vector.add(nombre);
	
			modelo.addRow(vector);
			vector = new Vector();
		}
		
		tabla.setModel(modelo);
		
	}
}
