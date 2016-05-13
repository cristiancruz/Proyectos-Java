package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.DropExcel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AlumnosEnPapelera extends JFrame {

	private JPanel contentPane;
	private JButton btnRegresar;
	DefaultTableModel modelo= new DefaultTableModel();
	private  JTable tab = new JTable();
	private JTextField txtBuscar;
	Alumno a = new Alumno();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnosEnPapelera frame = new AlumnosEnPapelera();
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
		AlumnosEnPapelera.this.setVisible(false);
        
    }  
	public AlumnosEnPapelera() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			close();
			}
		});
		setResizable(true);
		setTitle("Alumnos Liberados");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 675, 557);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelecioneAlumnoA = new JLabel("Alumnos Liberados:");
		lblSelecioneAlumnoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneAlumnoA.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		

		Alumno cl = new Alumno();		
		List<Alumno> lcl = cl.obtenerAlumEnPapelera(1);
		String Titulos[] = {"ID", "Nombre", "Apellido","Matricula","Carrera","Semestre","E-mail","Plan","Campus","Telefono","Horas","Fecha Liberacion"};
		 modelo = new DefaultTableModel(new Object[0][0], Titulos);	
		for(int i=0; i<lcl.size(); i++) {
			Object[] o = new Object[12];
	        o[0] = lcl.get(i).getId();
	        o[1] = lcl.get(i).getNombre();
	        o[2] = lcl.get(i).getApellido();
	        o[3] = lcl.get(i).getMatricula();
	        o[4] = lcl.get(i).getCarrera();
	        o[5] = lcl.get(i).getSemestre();
	        o[6] = lcl.get(i).getEmail();
	        o[7] = lcl.get(i).getPlan();
	        o[8] = lcl.get(i).getCampus();
	        o[9] = lcl.get(i).getTelefono();
	        o[10] = lcl.get(i).getHoras();
	        o[11] = lcl.get(i).getFecha();
	        
	        modelo.addRow(o);
		}		
		tab.setModel(modelo);
		tab.removeColumn(tab.getColumnModel().getColumn(0));
		 scrollPane .setViewportView(tab);
		 
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LiberarAlum a= new LiberarAlum();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				AlumnosEnPapelera.this.setVisible(false);
			}
		});
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String match = txtBuscar.getText();
				DefaultTableModel mo = new DefaultTableModel(null, Titulos);
				List<Alumno> almn = a.buscarComo(match);
				Vector v = new Vector();

				for(Alumno as : almn)
				{
					String id = String.valueOf(as.getId());
					String nombre = as.getNombre();
					String apellido = as.getApellido();
					String matricula = as.getMatricula();
					String carrera = as.getCarrera();
					String semestre=as.getSemestre();
					String email=as.getEmail();
					String plan=as.getPlan();
					String campus=as.getCampus();
					String tel=as.getTelefono();
					String horas=String.valueOf(as.getHoras());
					String fecha=as.getFecha();
					
					
					
					v.add(id);
					v.add(nombre);
					v.add(apellido);
					v.add(matricula);
					v.add(carrera);
					v.add(semestre);
					v.add(email);
					v.add(plan);
					v.add(campus);
					v.add(tel);
					v.add(horas);
					v.add(fecha);
					
					
					mo.addRow(v);
					v = new Vector();
				}
				
				tab.setModel(mo);
				tab.removeColumn(tab.getColumnModel().getColumn(0));
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
		
		JLabel lblBuscarAlumno = new JLabel("Buscar Alumno");
		lblBuscarAlumno.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(lblSelecioneAlumnoA, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
					.addGap(85))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBuscarAlumno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(txtBuscar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(296, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)))
					.addGap(42))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelecioneAlumnoA, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBuscarAlumno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnRegresar)
					.addGap(13))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
