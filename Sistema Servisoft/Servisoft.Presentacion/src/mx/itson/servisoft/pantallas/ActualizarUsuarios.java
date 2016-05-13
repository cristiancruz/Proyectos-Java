package mx.itson.servisoft.pantallas;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mx.itson.servisoft.entidades.Usuario;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActualizarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JTable tab = new JTable();
	DefaultTableModel modelo= new DefaultTableModel();
	private JTextField txtUser;
	private JTextField txtPass1;
	private JTextField txtPass2;
	private JTextField txtId;
	JScrollPane scrollPane = new JScrollPane();
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarUsuarios frame = new ActualizarUsuarios();
					frame.setVisible(true);
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
			ActualizarUsuarios.this.setVisible(false);
    }  
	public void llenadoaTabla(){

		
		Usuario usuario= new Usuario();
		List<Usuario> lus=usuario.listaUser();
		String Titulos[] = {"Id", "Usuario","Contraseña"};
		modelo = new DefaultTableModel(new Object[0][0], Titulos);	
		for(int i=0; i<lus.size(); i++) {
			Object[] o = new Object[3];
	        o[0] = lus.get(i).getId();
	        o[1] = lus.get(i).getUsuario();
	        o[2] = lus.get(i).getPass();
	        modelo.addRow(o);
		}
		tab.setModel(modelo);
		scrollPane.setViewportView(tab);
	}
	public ActualizarUsuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				close();
			}
		});
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 929, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		llenadoaTabla();
		tab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tab.getSelectedRow();
				String id = (String.valueOf(tab.getValueAt(fila, 0)));
				String user = (String.valueOf(tab.getValueAt(fila, 1)));
				
				txtId.setText(id);
				txtUser.setText(user);
			}
		});
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Nueva Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 18));
		
		txtPass1 = new JTextField();
		txtPass1.setColumns(10);
		
		JLabel lblContrasea_1 = new JLabel("Repita Contrase\u00F1a:");
		lblContrasea_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		txtPass2 = new JTextField();
		txtPass2.setColumns(10);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtId.getText().isEmpty() && !txtPass1.getText().isEmpty() && !txtPass2.getText().isEmpty()){
						if(txtPass1.getText().equals(txtPass2.getText())){
					Usuario usuario= new Usuario();
						int id= Integer.parseInt(txtId.getText());	
					usuario.Actualizar(id, txtPass1.getText());
					JOptionPane.showMessageDialog(null, "Usuario Actualizado");
					llenadoaTabla();
					txtId.setText("");
					txtPass1.setText("");
					txtPass2.setText("");
					txtUser.setText("");
						}else{JOptionPane.showMessageDialog(null, "Verifique contraseñas");}
				}else{
					JOptionPane.showMessageDialog(null, "LLene campos correspondientes");
				}
			}
		});
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI a= new GUI();
				a.setExtendedState(MAXIMIZED_BOTH);
				a.setVisible(true);
				ActualizarUsuarios.this.setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(689)
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(82)
									.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContrasea_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtPass1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtPass2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(lblContrasea_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(txtPass1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(txtPass2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnNewButton)))
					.addGap(65)
					.addComponent(btnRegresar)
					.addGap(14)
					.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
}
