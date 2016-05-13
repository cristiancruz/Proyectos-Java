package mx.itson.servisoft.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.Servicio;
import mx.itson.servisoft.entidades.Usuario;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ActualizarServicio extends JFrame {

	private JPanel contentPane;
	 Alumno alumno = new Alumno();
	 JTable tab = new JTable();
	 DefaultTableModel modelo= new DefaultTableModel();
	 private JTextField txtIdServ;
	 JScrollPane scrollPane = new JScrollPane();
	 private final JButton btnRegresar = new JButton("Regresar");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarServicio frame = new ActualizarServicio();
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
		ActualizarServicio.this.setVisible(false);
        
    }  
	public void llenarTab(){
		Servicio serv = new Servicio();		
		List<Servicio> listServ = serv.obtenerSerEnProceso(0);
		String Titulos[] = {"ID", "Semestre", "Duracion","Horario","Horas","Nombre alumno","Apellido","Proyecto"};
		 modelo = new DefaultTableModel(new Object[0][0], Titulos);	
		for(int i=0; i<listServ.size(); i++) {
			Object[] o = new Object[8];
	        o[0] = listServ.get(i).getId();
	        o[1] = listServ.get(i).getSemestreRealizacion();
	        o[2] = listServ.get(i).getDuracion();
	        o[3] = listServ.get(i).getHorario();
	        o[4] = listServ.get(i).getTotalHoras();
	        o[5] = listServ.get(i).getAlumno().getNombre();
	        o[6] = listServ.get(i).getAlumno().getApellido();
	        o[7] = listServ.get(i).getProyecto().getNombreProyecto();
	        
	        modelo.addRow(o);
		}
		tab.setModel(modelo);
		 scrollPane .setViewportView(tab);
		 
	}
	public ActualizarServicio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				close();
			}
		});
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setExtendedState(MAXIMIZED_BOTH);
				a.setVisible(true);
				ActualizarServicio.this.setVisible(false);
			}
		});
		btnRegresar.setToolTipText("");
		setTitle("Finalizar Servicios");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 983, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSeleccionarServicio = new JLabel("Seleccionar Servicio");
		lblSeleccionarServicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarServicio.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		
		llenarTab();

		tab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila= tab.getSelectedRow();
				String id=(String.valueOf(tab.getValueAt(fila, 0)));
				txtIdServ.setText(id);
			}
		});
		
		 JButton btnTerminarServ = new JButton("Terminar Servicio");
		 btnTerminarServ.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		if(!txtIdServ.getText().isEmpty()){
				Servicio servicio= new Servicio();
				int id= Integer.parseInt(txtIdServ.getText());	
				servicio.Actualizar(id, true);
				JOptionPane.showMessageDialog(null, "Servicio Terminado");
				llenarTab();
				txtIdServ.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Selecione un Servicio");
				}
		 	}
		 });
		 btnTerminarServ.setToolTipText("Seleccione un servicio y presione el boton terminar.");
		 
		 txtIdServ = new JTextField();
		 txtIdServ.setEnabled(false);
		 txtIdServ.setEditable(false);
		 txtIdServ.setColumns(10);
		 GroupLayout gl_contentPane = new GroupLayout(contentPane);
		 gl_contentPane.setHorizontalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGap(29)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addComponent(txtIdServ, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
		 					.addContainerGap())
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
		 						.addComponent(lblSeleccionarServicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
		 						.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
		 					.addGap(35))))
		 		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		 			.addContainerGap(515, Short.MAX_VALUE)
		 			.addComponent(btnTerminarServ, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
		 			.addGap(252))
		 );
		 gl_contentPane.setVerticalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGap(16)
		 			.addComponent(lblSeleccionarServicio, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
		 			.addGap(11)
		 			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(txtIdServ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 			.addGap(16)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(btnTerminarServ)
		 				.addComponent(btnRegresar)))
		 );
		 contentPane.setLayout(gl_contentPane);
		}
	}


