package itson.mx.rabiosa.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar p = new Registrar();
				p.setVisible(true);
				Gui.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(33, 37, 182, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Configurar Importes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configurar a= new Configurar();
				a.setVisible(true);
				Gui.this.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(33, 257, 182, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Generar Recibos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recibo a= new Recibo();
				a.setVisible(true);
				Gui.this.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(33, 103, 182, 55);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Historial");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Historial a= new Historial();
				a.setVisible(true);
				Gui.this.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(33, 178, 183, 55);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Pagar Recibos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Por el momento no disponible");
			}
		});
		btnNewButton_4.setBounds(33, 333, 182, 45);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\CristianAlejandro\\workspace\\Rabiosa.Presentacion\\src\\mx\\itson\\rabiosa\\imagenes\\cfe.png"));
		lblNewLabel.setBounds(238, 129, 236, 143);
		contentPane.add(lblNewLabel);
	}
}
