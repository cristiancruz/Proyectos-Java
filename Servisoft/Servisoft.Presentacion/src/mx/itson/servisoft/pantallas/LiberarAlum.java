package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.util.List;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Proyecto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LiberarAlum extends JFrame {

	private JPanel contentPane;
	private JButton btnRegresar;
	private JButton btnLiberar;
	private JMenuBar menuBar;
	DefaultTableModel modelo= new DefaultTableModel();
	JTable tblDatos = new JTable();
	private JTextField txtId;
	private JLabel lblBuscarAlumno;
	private JTextField txtName;
	JScrollPane scrollPane = new JScrollPane();
	Alumno alumno = new Alumno();
	String Titulos[] = {"ID", "Nombre", "Apellido","Matricula","Carrera","Semestre","E-mail","Plan","Campus","Telefono","Horas"};
	private JTextField txthoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiberarAlum frame = new LiberarAlum();
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
		LiberarAlum.this.setVisible(false);
        
    }  
	public void tablaCompleta(){
		Alumno cl = new Alumno();		
		List<Alumno> lcl = cl.obtenerAlumNormal(0);
		modelo = new DefaultTableModel(null,Titulos);	
		for(int i=0; i<lcl.size(); i++) {
			Object[] o = new Object[11];
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
			modelo.addRow(o);

		}		tblDatos.setModel(modelo);
		scrollPane .setViewportView(tblDatos);

	}
	public void buscar(){
		Alumno cl = new Alumno();		
		modelo.setRowCount(0);
		if(txtName.getText() == "")
		{
			alumno.buscarPorApellido(txtName.getText());
			List<Alumno> lAlum =alumno.buscarPorApellido(txtName.getText());
			
			modelo = new DefaultTableModel(null, Titulos);
			Object[] o = new Object[11];

			for(int i=0; i<lAlum.size(); i++) {
				o[0] = lAlum.get(i).getId();
				o[1] = lAlum.get(i).getNombre();
				o[2] = lAlum.get(i).getApellido();
				o[3] = lAlum.get(i).getMatricula();
				o[4] = lAlum.get(i).getCarrera();
				o[5] = lAlum.get(i).getSemestre();
				o[6] = lAlum.get(i).getEmail();
				o[7] = lAlum.get(i).getPlan();
				o[8] = lAlum.get(i).getCampus();
				o[9] = lAlum.get(i).getTelefono();
				o[10] = lAlum.get(i).getHoras();	
				 modelo.addRow(o);
			}
			tblDatos.setModel(modelo);
		}
		else
		{
			alumno.buscarPorApellido(txtName.getText());
			List<Alumno> lAlum =alumno.buscarPorApellido(txtName.getText());
			
			modelo = new DefaultTableModel(null, Titulos);
			Object[] o = new Object[11];

			for(int i=0; i<lAlum.size(); i++) {
				o[0] = lAlum.get(i).getId();
				o[1] = lAlum.get(i).getNombre();
				o[2] = lAlum.get(i).getApellido();
				o[3] = lAlum.get(i).getMatricula();
				o[4] = lAlum.get(i).getCarrera();
				o[5] = lAlum.get(i).getSemestre();
				o[6] = lAlum.get(i).getEmail();
				o[7] = lAlum.get(i).getPlan();
				o[8] = lAlum.get(i).getCampus();
				o[9] = lAlum.get(i).getTelefono();
				o[10] = lAlum.get(i).getHoras();	
				 modelo.addRow(o);
			}
			tblDatos.setModel(modelo);
		}
	}
public LiberarAlum() {
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
		close();
		}
	});
		setResizable(true);
		setTitle("Liberar Alumnos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 686, 557);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		tablaCompleta();
		
		tblDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tblDatos.getSelectedRow();
				String id = (String.valueOf(tblDatos.getValueAt(fila, 0)));
				String horas = (String.valueOf(tblDatos.getValueAt(fila, 10)));
				txtId.setText(id);
				txthoras.setText(horas);

			}
		});
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				LiberarAlum.this.setVisible(false);
			}
		});
		
		btnLiberar = new JButton("Liberar");
		btnLiberar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date now = new Date();
				DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
				String fecha = df1.format(now);
				if(!txtId.getText().isEmpty() ){
					int valor=Integer.parseInt(txthoras.getText());
					if(valor>=500){
					Alumno alumno= new Alumno();
					int id= Integer.parseInt(txtId.getText());
					alumno.liberarAlumno(id,true,fecha);	
					JOptionPane.showMessageDialog(null, "Alumno liberado");
					txtId.setText("");
					txthoras.setText("");
					tablaCompleta();
					}else{
						JOptionPane.showMessageDialog(null, "Horas insuficientes para operacion");
						txtId.setText("");
						txthoras.setText("");
						tblDatos.clearSelection();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Selecione Alumno a liberar");
				}
			}
		});

		menuBar = new JMenuBar();
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAlumnosLiberados = new JMenuItem("Alumnos Liberados");
		mntmAlumnosLiberados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnosEnPapelera a= new AlumnosEnPapelera();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				LiberarAlum.this.setVisible(false);
			}
		});
		mnArchivo.add(mntmAlumnosLiberados);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		lblBuscarAlumno = new JLabel("Buscar");
		lblBuscarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarAlumno.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Alumno a= new Alumno();
				String match = txtName.getText();
				DefaultTableModel mo = new DefaultTableModel(null, Titulos);
				List<Alumno> almn = a.buscarComo2(match);
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
				
					
					
					mo.addRow(v);
					v = new Vector();
				}
				
				tblDatos.setModel(mo);
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'a' || numeros>'z')) {
		            e.consume();
		        }
			}
			
		});
		txtName.setColumns(10);
		
		txthoras = new JTextField();
		txthoras.setEnabled(false);
		txthoras.setEditable(false);
		txthoras.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblBuscarAlumno, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txthoras, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
							.addComponent(btnLiberar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(txtName))
						.addComponent(lblBuscarAlumno, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLiberar)
								.addComponent(btnRegresar)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txthoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(11))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
