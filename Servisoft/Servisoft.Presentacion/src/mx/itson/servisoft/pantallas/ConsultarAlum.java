package mx.itson.servisoft.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Servicio;

public class ConsultarAlum extends JFrame {

	private JPanel contentPane;

	List<Servicio> servicios = new ArrayList<Servicio>();
	
	private JTable tblAlumno;
	private JTextField txtAlumno;
	private JTable tblProyecto;
	String[] titulosAlumnos = {"Id", "Nombre" , "Apellido"};
	String[] titulosProyectos = {"Id", "Nombre"};
	DefaultTableModel modeloAlumnos = new DefaultTableModel(null, titulosAlumnos);
	DefaultTableModel modeloProyectos = new DefaultTableModel(null, titulosProyectos);
	Alumno a = new Alumno();
	Servicio s = new Servicio();
	List<Servicio> serv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarAlum frame = new ConsultarAlum();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
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
		ConsultarAlum.this.setVisible(false);
        
    }  
	public void llenarTable(){
		List<Alumno> almn = a.buscarAlum("");
		
		Vector v = new Vector();
		modeloAlumnos.setRowCount(0);
		modeloAlumnos.setColumnIdentifiers(titulosAlumnos);
		for(Alumno as : almn)
		{
			String idAlumno = String.valueOf(as.getId());
			String nombre = as.getNombre();
			String apellido = as.getApellido();
			
			v.add(idAlumno);
			v.add(nombre);
			v.add(apellido);
			
			modeloAlumnos.addRow(v);
			v = new Vector();
		}
		
		tblAlumno.setModel(modeloAlumnos);
	}
	public ConsultarAlum() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			close();
			}
		});
		setTitle("Consultar Alumnos");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1113, 754);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 
		JScrollPane scrollPane = new JScrollPane();
		tblAlumno = new JTable();
		tblProyecto = new JTable();
		llenarTable();
		tblAlumno.removeColumn(tblAlumno.getColumnModel().getColumn(0));
		
		tblAlumno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tblAlumno.getSelectedRow();
				int id = Integer.parseInt(modeloAlumnos.getValueAt(fila, 0).toString());
			
				List<Servicio> servicios = s.buscarPorIdAlumno(id);
				serv = servicios;
				if(!servicios.isEmpty())
				{
					modeloAlumnos.setRowCount(0);
					String[] titulosNuevos = {"Id","Nombre","Apellido","Matricula","Semestre", "Carrera","E-mail","Plan","Campus","Telefono","TotalHoras"};
					modeloAlumnos.setColumnIdentifiers(titulosNuevos);
					Servicio servicio = servicios.get(0);
					int idAlumno =servicio.getAlumno().getId();
					String nombre = servicio.getAlumno().getNombre();
					String apellido = servicio.getAlumno().getApellido();
					String matricula = servicio.getAlumno().getMatricula();
					String semestre = servicio.getAlumno().getSemestre();
					String carrera = servicio.getAlumno().getCarrera();
					String email = servicio.getAlumno().getEmail();
					String plan = servicio.getAlumno().getPlan();
					String camp = servicio.getAlumno().getCampus();
					String tel = servicio.getAlumno().getTelefono();
					
					
					int horas = servicio.getAlumno().getHoras();
					
					Vector vector = new Vector();
					vector.add(idAlumno);
					vector.add(nombre);
					vector.add(apellido);
					vector.add(matricula);
					vector.add(semestre);
					vector.add(carrera);
					vector.add(email);
					vector.add(plan);
					vector.add(camp);
					vector.add(tel);
					vector.add(horas);
					
					
					modeloAlumnos.addRow(vector);
					vector = new Vector();
					tblAlumno.setModel(modeloAlumnos);
					
					modeloProyectos.setRowCount(0);
					
					
					for(Servicio se : servicios)
					{
						String nombreProyecto = se.getProyecto().getNombreProyecto();
						int idProyecto = se.getProyecto().getId();
						Vector v = new Vector();
						v.add(idProyecto);
						v.add(nombreProyecto);
						modeloProyectos.addRow(v);
						v = new Vector();
						tblProyecto.setModel(modeloProyectos);
						tblAlumno.removeColumn(tblAlumno.getColumnModel().getColumn(0));
					}
				}	
				else
				{
					JOptionPane.showMessageDialog(null, "El alumno no cuenta con ningun servicio social registrado");
				}
				
			}
		});
		scrollPane.setViewportView(tblAlumno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tblProyecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tblProyecto.getSelectedRow();
				int idProyecto = Integer.parseInt(modeloProyectos.getValueAt(fila, 0).toString());
				String [] headers = {"Id" , "NombreProyecto" ,"Contacto Empresa","Telefono", "Horas" , "Estatus"};
				modeloProyectos.setRowCount(0);
				modeloProyectos.setColumnIdentifiers(headers);
				for(Servicio se : serv)
				{
					int id = se.getProyecto().getId();
					if(idProyecto == id)
					{
						String nombreProyecto = se.getProyecto().getNombreProyecto();
						String cont=se.getProyecto().getContactoEmpresa();
						String tel=se.getProyecto().getTelefono();
						int horas = se.getTotalHoras();
						boolean status = se.isStatus();
						String estatus;
						if(status == false)
							estatus = "En proceso";
						else
							estatus = "Terminado";
						
						Vector nuevo = new Vector();
						nuevo.add(id);
						nuevo.add(nombreProyecto);
						nuevo.add(cont);
						nuevo.add(tel);
						nuevo.add(horas);
						nuevo.add(estatus);
						modeloProyectos.addRow(nuevo);
						nuevo = new Vector();
						tblProyecto.setModel(modeloProyectos);
					}
				}
			}
		});
		scrollPane_1.setViewportView(tblProyecto);
		
		tblAlumno.setModel(modeloAlumnos);
		tblProyecto.setModel(modeloProyectos);
		
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(ConsultarAlum.class.getResource("/itson/mx/servisoft/imagenes/abcsss.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloProyectos.setRowCount(0);
				modeloProyectos.setColumnIdentifiers(titulosProyectos);
				
				for(Servicio se : serv)
				{
					String nombreProyecto = se.getProyecto().getNombreProyecto();
					int idProyecto = se.getProyecto().getId();
					Vector v = new Vector();
					v.add(idProyecto);
					v.add(nombreProyecto);
					modeloProyectos.addRow(v);
					v = new Vector();
					tblProyecto.setModel(modeloProyectos);
				}
			}
		});
		
		JLabel label = new JLabel("Proyectos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		panel_1.setLayout(gl_panel_1);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				ConsultarAlum.this.setVisible(false);
			}
		});
		
		txtAlumno = new JTextField();
		txtAlumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String match = txtAlumno.getText();
				List<Alumno> almn = a.buscarAlum(match);
				
				Vector v = new Vector();
				modeloAlumnos.setRowCount(0);
				modeloAlumnos.setColumnIdentifiers(titulosAlumnos);
				for(Alumno as : almn)
				{
					String idAlumno = String.valueOf(as.getId());
					String nombre = as.getNombre();
					String apellido = as.getApellido();
					
					v.add(idAlumno);
					v.add(nombre);
					v.add(apellido);
					
					modeloAlumnos.addRow(v);
					v = new Vector();
				}
				
				tblAlumno.setModel(modeloAlumnos);
				tblAlumno.removeColumn(tblAlumno.getColumnModel().getColumn(0));
			}
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char car = e.getKeyChar();
		        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
		                && (car != (char) KeyEvent.VK_SPACE)) 
		        {
		            e.consume();
		        }
		    }
		});
		txtAlumno.setColumns(10);
		
		JLabel lblBuscarPorNombre = new JLabel("Buscar por nombre o apellido");
		lblBuscarPorNombre.setForeground(Color.DARK_GRAY);
		lblBuscarPorNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		JButton btnRegresarAlumnos = new JButton("");
		btnRegresarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarTable();
				DefaultTableModel modeloProyectos = new DefaultTableModel(null, titulosProyectos);
				tblProyecto.setModel(modeloProyectos);
				tblAlumno.removeColumn(tblAlumno.getColumnModel().getColumn(0));
			}
		});
		btnRegresarAlumnos.setIcon(new ImageIcon(ConsultarAlum.class.getResource("/itson/mx/servisoft/imagenes/abcsss.png")));
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtAlumno, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblBuscarPorNombre, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(554, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnRegresarAlumnos, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAlumno, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBuscarPorNombre))
					.addGap(18)
					.addComponent(btnRegresarAlumnos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnos.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAlumnos, GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 941, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAlumnos, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
