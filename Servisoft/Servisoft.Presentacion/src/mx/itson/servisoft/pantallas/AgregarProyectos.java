package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Proyecto;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgregarProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField txtTipoProg;
	private JTextField txtEmpresa;
	private JTextField txtTelefono;
	private JTextField txtContactoEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProyectos frame = new AgregarProyectos();
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
	JButton btnRegresar = new JButton("Regresar");
	JMenu mnArchivo = new JMenu("Archivo");
	private void close(){
		Object [] opciones ={"Aceptar","Cancelar"}; 
		int eleccion = JOptionPane.showOptionDialog(null,"En realidad desea cerrar el sistema","Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar"); 
		if (eleccion == JOptionPane.YES_OPTION) { 
			new Control().cerrarApp(); 
		}
    } 
	public void ocultarOption() {
		btnRegresar.setVisible(false);
		btnRegresar.setEnabled(false);
		mnArchivo.setEnabled(true);
	}

	public AgregarProyectos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		setResizable(false);
		setTitle("Registrar Proyecto");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 690, 534);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo.setEnabled(false);
		menuBar.add(mnArchivo);

		JMenuItem mntmAgregarServcio = new JMenuItem("Registrar Servcio");
		mntmAgregarServcio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarSer a = new AgregarSer();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.bloqueAMenu();
				a.setExtendedState(MAXIMIZED_BOTH);
				AgregarProyectos.this.setVisible(false);
			}
		});
		mnArchivo.add(mntmAgregarServcio);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setBounds(813, 630, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI a = new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				AgregarProyectos.this.setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(66, 5, 556, 469);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		btnRegresar.setBounds(380, 414, 98, 30);

		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI a = new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				AgregarProyectos.this.setVisible(false);
			}
		});

		JLabel lblNombreProyecto = new JLabel("Nombre Proyecto: ");
		lblNombreProyecto.setBounds(5, 51, 153, 35);
		lblNombreProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreProyecto.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblTipoPrograma = new JLabel("Tipo Programa:");
		lblTipoPrograma.setBounds(18, 125, 131, 35);
		lblTipoPrograma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoPrograma.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSector = new JLabel("Sector:");
		lblSector.setBounds(18, 171, 123, 35);
		lblSector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSector.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblGiro = new JLabel("Giro:");
		lblGiro.setBounds(18, 217, 123, 35);
		lblGiro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiro.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(18, 263, 123, 35);
		lblEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpresa.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(18, 309, 123, 35);
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblContactoEmpresa = new JLabel("Contacto Empresa:");
		lblContactoEmpresa.setBounds(5, 356, 140, 35);
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactoEmpresa.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblContador2 = new JLabel("50");
		lblContador2.setBounds(496, 281, 45, 17);
		JLabel lblContador3 = new JLabel("15");
		lblContador3.setBounds(496, 327, 45, 17);
		JLabel lblContador4 = new JLabel("45");
		lblContador4.setBounds(496, 374, 45, 17);

		JComboBox cbxSector = new JComboBox();
		cbxSector.setBounds(168, 173, 310, 27);
		cbxSector.setBackground(Color.LIGHT_GRAY);
		cbxSector.setModel(new DefaultComboBoxModel(new String[] { "PUBLICO",
				"PRIVADO", "SOCIAL", "INTERNO" }));
		cbxSector.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(168, 47, 310, 60);
		JLabel lblContador = new JLabel("100");
		lblContador.setBounds(496, 92, 45, 17);

		JTextArea taNombre = new JTextArea();
		taNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String cadena = taNombre.getText();
				int chars = 100;
				chars = chars - cadena.length();
				lblContador.setText(String.valueOf(chars));
				if (chars <= 0)
					taNombre.setBorder(BorderFactory.createLineBorder(
							Color.red, 1));
				else
					taNombre.setBorder(BorderFactory
							.createLineBorder(Color.LIGHT_GRAY));
			}
		});
		taNombre.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(taNombre);
		taNombre.setLineWrap(true);
		taNombre.setWrapStyleWord(true);
		taNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

		JComboBox cbxGiro = new JComboBox();
		cbxGiro.setBounds(168, 217, 310, 28);
		cbxGiro.setBackground(Color.LIGHT_GRAY);
		cbxGiro.setModel(new DefaultComboBoxModel(new String[] { "EDUCATIVO",
				"SERVICIO", "INDUSTRIAL", "ITSON", "COMERCIAL" }));
		cbxGiro.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		txtTipoProg = new JTextField();
		txtTipoProg.setBounds(168, 127, 310, 30);
		txtTipoProg.setBackground(Color.LIGHT_GRAY);
		txtTipoProg.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtTipoProg.setColumns(10);

		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(168, 265, 310, 33);
		txtEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String cadena = txtEmpresa.getText();
				int chars = 50;
				chars = chars - cadena.length();
				lblContador2.setText(String.valueOf(chars));
				if (chars <= 0)
					txtEmpresa.setBorder(BorderFactory.createLineBorder(
							Color.red, 1));
				else
					txtEmpresa.setBorder(BorderFactory
							.createLineBorder(Color.LIGHT_GRAY));
			}
		});
		txtEmpresa.setBackground(Color.LIGHT_GRAY);
		txtEmpresa.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtEmpresa.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(168, 311, 310, 33);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numeros = e.getKeyChar();

		        if((numeros<'0' || numeros>'9')) {
		            e.consume();
		        }
				String cadena = txtTelefono.getText();
				int chars = 15;
				chars = chars - cadena.length();
				lblContador3.setText(String.valueOf(chars));
				if (chars <= 0)
					txtTelefono.setBorder(BorderFactory.createLineBorder(
							Color.red, 1));
				else
					txtTelefono.setBorder(BorderFactory
							.createLineBorder(Color.LIGHT_GRAY));
			}
		});
		txtTelefono.setBackground(Color.LIGHT_GRAY);
		txtTelefono.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtTelefono.setColumns(10);

		txtContactoEmp = new JTextField();
		txtContactoEmp.setBounds(168, 357, 310, 34);
		txtContactoEmp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String cadena = txtContactoEmp.getText();
				int chars = 45;
				chars = chars - cadena.length();
				lblContador4.setText(String.valueOf(chars));
				if (chars <= 0)
					txtContactoEmp.setBorder(BorderFactory.createLineBorder(
							Color.red, 1));
				else
					txtContactoEmp.setBorder(BorderFactory
							.createLineBorder(Color.LIGHT_GRAY));
			}
		});
		txtContactoEmp.setBackground(Color.LIGHT_GRAY);
		txtContactoEmp.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtContactoEmp.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(261, 414, 98, 30);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Proyecto proyecto = new Proyecto();
				if (!taNombre.getText().isEmpty()
						&& !txtTipoProg.getText().isEmpty()
						&& cbxSector.getSelectedIndex() > -1
						&& cbxGiro.getSelectedIndex() > -1
						&& !txtEmpresa.getText().isEmpty()
						&& !txtTelefono.getText().isEmpty()
						&& !txtContactoEmp.getText().isEmpty()) 
				{
					String nombre_proyecto = taNombre.getText();
					String tipo_programa = txtTipoProg.getText();
					String sector = cbxSector.getSelectedItem().toString();
					String giro = cbxGiro.getSelectedItem().toString();
					String empresa = txtEmpresa.getText();
					String telefono = txtTelefono.getText();
					String contacto = txtContactoEmp.getText();

					if (proyecto.guardar(nombre_proyecto, tipo_programa,
							sector, giro, empresa, telefono, contacto)) 
					{
						JOptionPane.showMessageDialog(null,
								"Guardado con éxito");
						taNombre.setText("");
						txtTipoProg.setText("");
						cbxSector.setSelectedIndex(-1);
						cbxGiro.setSelectedIndex(-1);
						txtEmpresa.setText("");
						txtTelefono.setText("");
						txtContactoEmp.setText("");
					}else{
						JOptionPane.showMessageDialog(null, "Este proyecto ya existe");
					}

				} 
				else 
				{
					JOptionPane.showMessageDialog(null,
							"Falta llenar algun campo");
				}
			}
		});

		JLabel label_10 = new JLabel("Ingresar Datos");
		label_10.setBounds(235, 5, 153, 35);
		label_10.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		panel.setLayout(null);
		panel.add(label_10);
		panel.add(lblNombreProyecto);
		panel.add(scrollPane);
		panel.add(lblContador);
		panel.add(lblTipoPrograma);
		panel.add(txtTipoProg);
		panel.add(lblSector);
		panel.add(cbxSector);
		panel.add(lblGiro);
		panel.add(cbxGiro);
		panel.add(lblEmpresa);
		panel.add(txtEmpresa);
		panel.add(lblContador2);
		panel.add(lblTelefono);
		panel.add(txtTelefono);
		panel.add(lblContador3);
		panel.add(lblContactoEmpresa);
		panel.add(txtContactoEmp);
		panel.add(lblContador4);
		panel.add(btnGuardar);
		panel.add(btnRegresar);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(panel);

	}
}
