package itson.mx.rabiosa.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import mx.itson.rabiosa.entidades.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Registrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCodigoPostal;
	private JTextField txtNumeroContrato;
	private JTextField txtNumeroMedidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar();
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
	//metodo para llenar texfield de numero de medidor y numero de contrato
	public void numerosAleatorios(){
	int num1=0;
	int num2=1000;
	int numAleatorio1=(int)Math.floor(Math.random()*(num2-num1)+num1);
	
	int uno=1001;
	int dos=2000;
	int numAleatorio2=(int)Math.floor(Math.random()*(dos-uno)+uno);
	txtNumeroContrato.setText(String.valueOf(numAleatorio1));
	txtNumeroMedidor.setText(String.valueOf(numAleatorio2));
	
	txtNumeroContrato.setEditable(false); 
	txtNumeroMedidor.setEditable(false); 
	}
	public Registrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarDatos = new JLabel("Registrar Datos");
		lblRegistrarDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrarDatos.setBounds(151, 29, 123, 28);
		contentPane.add(lblRegistrarDatos);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(56, 71, 75, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 68, 178, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(56, 105, 75, 14);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(141, 99, 178, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDirecion = new JLabel("Direccion:");
		lblDirecion.setBounds(56, 144, 75, 14);
		contentPane.add(lblDirecion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(141, 141, 178, 20);
		contentPane.add(txtDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(56, 192, 75, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(141, 189, 178, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblCp = new JLabel("C.p :");
		lblCp.setBounds(56, 235, 75, 14);
		contentPane.add(lblCp);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setBounds(141, 232, 178, 20);
		contentPane.add(txtCodigoPostal);
		
		JLabel lblNumeroDeContrato = new JLabel("Numero de Contrato :");
		lblNumeroDeContrato.setBounds(10, 277, 123, 14);
		contentPane.add(lblNumeroDeContrato);
		
		txtNumeroContrato = new JTextField();
		txtNumeroContrato.setColumns(10);
		txtNumeroContrato.setBounds(141, 274, 178, 20);
		contentPane.add(txtNumeroContrato);
		
		JLabel lblNumeroDeMedidor = new JLabel("Numero de Medidor:");
		lblNumeroDeMedidor.setBounds(10, 318, 121, 14);
		contentPane.add(lblNumeroDeMedidor);
		
		txtNumeroMedidor = new JTextField();
		txtNumeroMedidor.setColumns(10);
		txtNumeroMedidor.setBounds(141, 315, 178, 20);
		contentPane.add(txtNumeroMedidor);
		//llamado del metodo de llenado de texfiel de medidor y de contrato
		numerosAleatorios();
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//para poder guardar
				Cliente cliente = new Cliente();
				int contrato = Integer.parseInt(txtNumeroContrato.getText());
				int medidor = Integer.parseInt(txtNumeroMedidor.getText());
				if (!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDireccion.getText().isEmpty() && !txtTelefono.getText().isEmpty() && !txtCodigoPostal.getText().isEmpty() && !txtNumeroContrato.getText().isEmpty() && !txtNumeroMedidor.getText().isEmpty()) {

            cliente.guardar(txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCodigoPostal.getText(), contrato, medidor);
            JOptionPane.showMessageDialog(null, "Guardado con éxito");
            //al guardar limpiamos texfield y generamos valores para contratos y medidores nuevos
            txtNombre.setText("");
            txtApellido.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtCodigoPostal.setText("");
            numerosAleatorios();
        } else {
            JOptionPane.showMessageDialog(null, "Valores incorrectos");
        }
				  
				 
			}
		});
		btnGuardar.setBounds(141, 357, 178, 23);
		contentPane.add(btnGuardar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui a= new Gui();
				a.setVisible(true);
				Registrar.this.setVisible(false);
			}
		});
		btnRegresar.setBounds(335, 429, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnNewButton = new JButton("Generar recibo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recibo a= new Recibo();
				a.setVisible(true);
				Registrar.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(141, 391, 178, 23);
		contentPane.add(btnNewButton);
	}
}
