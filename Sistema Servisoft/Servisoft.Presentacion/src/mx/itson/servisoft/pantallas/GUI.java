package mx.itson.servisoft.pantallas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import java.awt.Color;

import javax.swing.UIManager;












import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.DropExcel;
import mx.itson.servisoft.entidades.Servicio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI extends JFrame {

	private JPanel contentPane;
	JButton btnRegistrarAlumno = new JButton("");
	JButton btnRegisProyecto = new JButton("");
	JButton btnEstadoServ = new JButton("");
	JButton btnConsulProy = new JButton("");
	JButton btnLiberarAlumno = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public void actualizarDatos()
	{
		Servicio s = new Servicio();
		Alumno a = new Alumno();
		List horas = s.getSumaHoras();
		List idAlumno = s.getIdAlumno();
		
		for(int i = 0; i < horas.size(); i++)
		{
			int totalHoras = Integer.parseInt(horas.get(i).toString());
			int id = Integer.parseInt(idAlumno.get(i).toString());
			if(a.actualizarHoras(id, totalHoras))
				System.out.println("good");
		}
	}
	public GUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				close();
			}
		});
		setTitle("Menu");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1205, 629);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActualizarUsuarios a = new 	ActualizarUsuarios();
				a.setExtendedState(MAXIMIZED_BOTH);
				a.setVisible(true);
				GUI.this.setVisible(false);
			}
		});
		actualizarDatos();
	
		mnArchivo.add(mntmUsuarios);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		btnRegistrarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarMasivo a= new AgregarMasivo();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				DropExcel de= new DropExcel(a.table);
				GUI.this.setVisible(false);
			}
		});
		btnRegistrarAlumno.setBackground(UIManager.getColor("Button.background"));
		btnRegistrarAlumno.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/Agregar Alumnos2.png")));
		
	
		btnEstadoServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EstadoDeServicio a= new EstadoDeServicio();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				GUI.this.setVisible(false);
			}
		});
		btnEstadoServ.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/estadoalumno2.png")));
		
		JLabel lblImportarExcel = new JLabel("Registrar Alumnos");
		lblImportarExcel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblAgrearManualmente = new JLabel("Estado de Servicios");
		lblAgrearManualmente.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblBusqueda = new JLabel("Consultar Alumnos");
		lblBusqueda.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		btnRegisProyecto.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRegisProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarProyectos a= new AgregarProyectos();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				GUI.this.setVisible(false);
			}
		});
		btnRegisProyecto.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/AgregarProyectos2.png")));
		
		JLabel lblProyectos = new JLabel("Registrar Proyectos");
		lblProyectos.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnConsultarAlum = new JButton("");
		btnConsultarAlum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarAlum a= new ConsultarAlum();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				GUI.this.setVisible(false);
			}
		});
		btnConsultarAlum.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/Consultar alumno2.png")));
		
		
		btnLiberarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LiberarAlum a= new LiberarAlum();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				GUI.this.setVisible(false);
			}
		});
		btnLiberarAlumno.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/liberarAlum2.png")));
		
		JLabel lblLiberacionDeAlumnos = new JLabel("Consultar Proyectos");
		lblLiberacionDeAlumnos.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnRegisServ = new JButton("");
		btnRegisServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarSer a= new AgregarSer();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				GUI.this.setVisible(false);
			}
		});
		btnRegisServ.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/addServ.png")));
		
		JLabel lblAgregarServicio = new JLabel("Registrar Servicios");
		lblAgregarServicio.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/LOGOTIPO SERVICIO SOCIAL PNG.png")));
		
		
		btnConsulProy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Busqueda_Proyecto a= new  Busqueda_Proyecto();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				GUI.this.setVisible(false);
			}
		});
		btnConsulProy.setIcon(new ImageIcon(GUI.class.getResource("/itson/mx/servisoft/imagenes/consultar proyectos.png")));
		
		JLabel label_1 = new JLabel("Liberar  Alumnos");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImportarExcel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRegistrarAlumno, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(17)))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProyectos, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(btnRegisProyecto, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(26)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAgregarServicio, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRegisServ, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(17)))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(btnEstadoServ, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(10))
						.addComponent(lblAgrearManualmente, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBusqueda, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(btnConsultarAlum, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(14)))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLiberacionDeAlumnos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnConsulProy, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(17)))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLiberarAlumno, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
							.addGap(7)))
					.addGap(35))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(446, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImportarExcel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnRegistrarAlumno, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblProyectos, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnRegisProyecto, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAgregarServicio, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnRegisServ, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnEstadoServ, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAgrearManualmente, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBusqueda, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnConsultarAlum, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblLiberacionDeAlumnos, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnConsulProy, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(btnLiberarAlumno, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
