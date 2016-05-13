package mx.itson.servisoft.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Servicio;
import mx.itson.servisoft.entidades.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPass;
	JComboBox cbxUsuario = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if( new Control().comprobar() )
					{
						Login frame = new Login();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					}        
					else
					{
						System.exit(0);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void accionClick(){
			
			Usuario usuario= new Usuario();
			GUI openGui = new GUI();
			AgregarProyectos a=new AgregarProyectos();
			AgregarSer agSer= new AgregarSer();
			String us = cbxUsuario.getSelectedItem().toString();

			if(cbxUsuario.getSelectedIndex() > -1 && !txtPass.getText().isEmpty()){
				if(usuario.acceso(us, txtPass.getText())==true){
					if(us=="ADMINISTRADOR"){
						actualizarDatos();
						openGui.setExtendedState(MAXIMIZED_BOTH);
						openGui.setVisible(true);
						Login.this.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bienvenido "+us);				
					}else{	
						agSer.setExtendedState(MAXIMIZED_BOTH);
						agSer.bloqueAMenu();
						a.ocultarOption();
						agSer.setVisible(true);												
						Login.this.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bienvenido "+us);		
					}				
				}else{
					JOptionPane.showMessageDialog(null, "Contraseña Erronea");
					txtPass.setText("");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Falta llenar campo");
			}
	 }
	private void close(){
		Object [] opciones ={"Aceptar","Cancelar"}; 
		int eleccion = JOptionPane.showOptionDialog(null,"En realidad desea cerrar la aplicacion","Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar"); 
		if (eleccion == JOptionPane.YES_OPTION) { 
			 new Control().cerrarApp();   
			//System.exit(0); 
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
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			close();
			}
		});
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 488, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 14));
		lblUsuario.setBounds(56, 82, 80, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Verdana", Font.BOLD, 14));
		lblContrasea.setBounds(41, 176, 95, 14);
		contentPane.add(lblContrasea);
		cbxUsuario.setFocusable(false);
		txtPass = new JPasswordField();
		txtPass.requestFocus();
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					accionClick();
					} 
			}
		});
		txtPass.setBackground(Color.WHITE);
		txtPass.setBounds(164, 175, 152, 20);
		contentPane.add(txtPass);
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accionClick();
			}
		});
		btnNewButton.setBounds(164, 245, 152, 23);
		contentPane.add(btnNewButton);
		cbxUsuario.setBackground(Color.LIGHT_GRAY);
		
		cbxUsuario.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "INVITADO"}));
		cbxUsuario.setBounds(164, 81, 152, 20);
		contentPane.add(cbxUsuario);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/itson/mx/servisoft/imagenes/user.png")));
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setBounds(342, 41, 80, 90);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/itson/mx/servisoft/imagenes/password.png")));
		label_1.setFont(new Font("Verdana", Font.BOLD, 14));
		label_1.setBounds(342, 150, 80, 90);
		contentPane.add(label_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saliendo del sistema");
				new Control().cerrarApp(); 
				//System.exit(0);
			}
		});
		btnCancelar.setBounds(164, 282, 152, 23);
		contentPane.add(btnCancelar);
	}
}
