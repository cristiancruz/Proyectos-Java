package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.DropExcel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class AgregarUno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtMatri;
	private JTextField txtCarrera;
	private JTextField txtSemestre;
	private JTextField txtEmail;
	private JTextField txtPlan;
	private JTextField txtCampus;
	private JTextField txtTel;
	private JButton btnGuardar;
	private JLabel lblIngresarDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarUno frame = new AgregarUno();
					frame.setVisible(true);
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
		AgregarUno.this.setVisible(false);
        
    }  
	public AgregarUno() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			close();
			}
		});
		setResizable(false);
		setTitle("Registrar Alumno");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 489, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarMasivo a= new AgregarMasivo();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				
				AgregarUno.this.setVisible(false);
			}
		});
		btnRegresar.setBounds(302, 464, 98, 30);
		contentPane.add(btnRegresar);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(23, 35, 123, 35);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellido.setBounds(23, 81, 123, 35);
		contentPane.add(lblApellido);
		
		JLabel lblMatricula = new JLabel("Matricula: ");
		lblMatricula.setFont(new Font("Arial", Font.BOLD, 14));
		lblMatricula.setBounds(23, 127, 123, 35);
		contentPane.add(lblMatricula);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Arial", Font.BOLD, 14));
		lblCarrera.setBounds(23, 173, 123, 35);
		contentPane.add(lblCarrera);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Arial", Font.BOLD, 14));
		lblSemestre.setBounds(23, 219, 123, 35);
		contentPane.add(lblSemestre);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(23, 265, 123, 35);
		contentPane.add(lblEmail);
		
		JLabel lblPlan = new JLabel("Plan:");
		lblPlan.setFont(new Font("Arial", Font.BOLD, 14));
		lblPlan.setBounds(23, 311, 123, 35);
		contentPane.add(lblPlan);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Arial", Font.BOLD, 14));
		lblCampus.setBounds(23, 357, 123, 35);
		contentPane.add(lblCampus);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefono.setBounds(23, 403, 123, 35);
		contentPane.add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char car = e.getKeyChar();
			        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
			                && (car != (char) KeyEvent.VK_SPACE)) {
			            e.consume();
			        }
			}
		});
		txtNombre.setBackground(Color.LIGHT_GRAY);
		txtNombre.setBounds(120, 43, 278, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
		        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
		                && (car != (char) KeyEvent.VK_SPACE)) {
		            e.consume();
		        }
			}
		});
		txtApellido.setBackground(Color.LIGHT_GRAY);
		txtApellido.setColumns(10);
		txtApellido.setBounds(120, 89, 278, 20);
		contentPane.add(txtApellido);
		
		txtMatri = new JTextField();
		txtMatri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'0' || numeros>'9')) {
		            e.consume();
		        }
				
			}
		});
		txtMatri.setBackground(Color.LIGHT_GRAY);
		txtMatri.setColumns(10);
		txtMatri.setBounds(120, 135, 278, 20);
		contentPane.add(txtMatri);
		
		txtCarrera = new JTextField();
		txtCarrera.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
		        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
		                && (car != (char) KeyEvent.VK_SPACE)) {
		            e.consume();
		        }
			}
		});
		txtCarrera.setBackground(Color.LIGHT_GRAY);
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(120, 181, 278, 20);
		contentPane.add(txtCarrera);
		
		txtSemestre = new JTextField();
		txtSemestre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'0' || numeros>'9')) {
		            e.consume();
		        }
			}
		});
		txtSemestre.setBackground(Color.LIGHT_GRAY);
		txtSemestre.setColumns(10);
		txtSemestre.setBounds(120, 227, 278, 20);
		contentPane.add(txtSemestre);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(120, 273, 278, 20);
		contentPane.add(txtEmail);
		
		txtPlan = new JTextField();
		txtPlan.setBackground(Color.LIGHT_GRAY);
		txtPlan.setColumns(10);
		txtPlan.setBounds(120, 319, 278, 20);
		contentPane.add(txtPlan);
		
		txtCampus = new JTextField();
		txtCampus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
		        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
		                && (car != (char) KeyEvent.VK_SPACE)) {
		            e.consume();
		        }
			}
		});
		txtCampus.setBackground(Color.LIGHT_GRAY);
		txtCampus.setColumns(10);
		txtCampus.setBounds(120, 365, 278, 20);
		contentPane.add(txtCampus);
		
		txtTel = new JTextField();
		txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'0' || numeros>'9')) {
		            e.consume();
		        }
			}
		});
		txtTel.setBackground(Color.LIGHT_GRAY);
		txtTel.setColumns(10);
		txtTel.setBounds(120, 411, 278, 20);
		contentPane.add(txtTel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Alumno alumno= new Alumno();
				 Date now = new Date();
                 DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
                 String fecha = df1.format(now);
			
                 if(!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtMatri.getText().isEmpty() && !txtCarrera.getText().isEmpty() && !txtSemestre.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtPlan.getText().isEmpty() && !txtCampus.getText().isEmpty() && !txtTel.getText().isEmpty())
 				{
 					if(txtMatri.getText().length()==11)
 					{
 						if(alumno.guardar(txtNombre.getText(), txtApellido.getText(), txtMatri.getText(), txtCarrera.getText(),txtSemestre.getText(), txtEmail.getText(), txtPlan.getText(), txtCampus.getText(), txtTel.getText(),0, false,fecha))
 						{
 							JOptionPane.showMessageDialog(null, "Guardado con éxito");
 							 txtNombre.setText("");
 							 txtApellido.setText("");
 							 txtMatri.setText("");
 							 txtCarrera.setText("");
 							 txtSemestre.setText("");
 							 txtEmail.setText("");
 							 txtPlan.setText("");
 							 txtCampus.setText("");
 							 txtTel.setText("");
 						}
 						else
 						{
 							if(alumno.actualizar(txtMatri.getText(), txtCarrera.getText(), txtSemestre.getText(), txtEmail.getText(), txtTel.getText()))
 	                    	{
 	                    		
 	                    			JOptionPane.showMessageDialog(null, "Campos guardados y actualizados.");
 	                    			 txtNombre.setText("");
 	    							 txtApellido.setText("");
 	    							 txtMatri.setText("");
 	    							 txtCarrera.setText("");
 	    							 txtSemestre.setText("");
 	    							 txtEmail.setText("");
 	    							 txtPlan.setText("");
 	    							 txtCampus.setText("");
 	    							 txtTel.setText("");
 	                    	}
 						}
 					 
 					}else{
 						JOptionPane.showMessageDialog(null, "La matricula tiene que ser de 11 digitos");
 					} 
 				}else{
 					JOptionPane.showMessageDialog(null, "Falta llenar algun campo");
 				}
		
			}
				
		});
		btnGuardar.setBounds(194, 464, 98, 30);
		contentPane.add(btnGuardar);
		
		lblIngresarDatos = new JLabel("Ingresar Datos");
		lblIngresarDatos.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		lblIngresarDatos.setBounds(191, 0, 153, 35);
		contentPane.add(lblIngresarDatos);
	}
}
