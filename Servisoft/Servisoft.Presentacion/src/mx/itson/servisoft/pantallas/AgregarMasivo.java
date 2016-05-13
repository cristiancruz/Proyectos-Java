package mx.itson.servisoft.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JScrollPane;

import mx.itson.servisoft.entidades.Alumno;
import mx.itson.servisoft.entidades.DropExcel;
import mx.itson.servisoft.entidades.crearexcel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgregarMasivo extends JFrame {

	private JPanel contentPane;
	DefaultTableModel modelo = new DefaultTableModel();
	DefaultTableModel model = new DefaultTableModel(
			new Object[][]
    		{
				{null, null, null, null, null},
				{null, null, null, null, null},
    		}, 
    		new String[]
    		{
				"New column", "New column", "New column", "New column", "New column"
    		});
	static JTable table = new JTable();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarMasivo frame = new AgregarMasivo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					DropExcel de= new DropExcel(table);
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
		AgregarMasivo.this.setVisible(false);
        
    }  
	public AgregarMasivo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			close();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Registrar Alumnos Por Excel");
		setResizable(true);
		setBounds(100, 100, 940, 712);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAgregarManualmente = new JMenu("Archivo");
		menuBar.add(mnAgregarManualmente);
		
		JLabel lblEsperar = new JLabel("");
		lblEsperar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Manualmente ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarUno a= new AgregarUno();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				AgregarMasivo.this.setVisible(false);
			}
		});
		mnAgregarManualmente.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getRowCount();
				
				try {

					for(int i = 1;i < fila; i++)
					{
	                    
	                    String matricula = table.getValueAt(i, 0).toString();
	                    String nombreCompleto = table.getValueAt(i, 1).toString();
	                    
	                    String[] cadena = cortarCadenaPorComas(nombreCompleto);
	                    
	                    
	                    if(cadena[0] != "")
	                    {
	                    	String nombre = cadena[1];
	                        String apellido = cadena[0];
	                        
	                        String carrera = table.getValueAt(i, 2).toString();
	                        String plan = table.getValueAt(i, 3).toString();
	                        String campus = table.getValueAt(i, 4).toString();
	                        String semestre = table.getValueAt(i, 5).toString();
	                        String email = table.getValueAt(i, 6).toString();
	                        String telefono = table.getValueAt(i, 7).toString();
	                        
	                        if(matricula != "" && nombre != "" && apellido != ""
	                        		&& carrera != "" && plan != "" && campus != ""
	                        		&& semestre != "" && email != "" && telefono != "")
	                        {
	                        	Date now = new Date();
	                            DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
	                            String fecha = df1.format(now);
	                         
	                            int horas = 0;
	                            boolean papelera = false;
	                            
	                            
	                            
	                            Alumno alumno = new Alumno();
	                            if(alumno.guardar(nombre, apellido, matricula, carrera, semestre, email, plan, campus, telefono, horas, papelera,fecha))
	                            {	
	                            	lblEsperar.setText("Guardando datos...");
	                            	if( fila - i == 1 )
	                            	{	
	                            		JOptionPane.showMessageDialog(null, "Lista Guardada");
	                            		table.setModel(model);
	                            		lblEsperar.setText("");	
	                            	}
	                            	
	                            }
	                            else
	                            {
	                            	if(alumno.actualizar(matricula, carrera, semestre, email, telefono))
	                            	{
	                            		if( fila - i == 1 )
	                            		{
	                            			JOptionPane.showMessageDialog(null, "Campos guardados y actualizados.");
	                            			table.setModel(model);
	                            			lblEsperar.setText("");
	                            		}
	                            	}
	                            }
	                        }
	                        else
	                        {
	                        	System.out.println("Hay un campo vacío en la fila " + i);
	                        }
	                    }
	                    else
	                    {
	                    	System.out.println("Hay un campo vacío en la fila " + i);
	                    	if( fila - i == 1 )
	                		{
	                			JOptionPane.showMessageDialog(null, "Campos guardados y actualizados.");
	                			table.setModel(model);
	                			lblEsperar.setText("");
	                		}
	                    }
	                    
	                 }
		        } catch (NullPointerException e) {
		        	JOptionPane.showMessageDialog(null, "Lista vacia- Agregue datos por excel");
		        }
			}
		});
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI a= new GUI();
				a.setLocationRelativeTo(null);
				a.setVisible(true);
				a.setExtendedState(MAXIMIZED_BOTH);
				AgregarMasivo.this.setVisible(false);
			}
		});
		
		JLabel lblAgregarListaDe = new JLabel("Agregar lista de Alumnos");
		lblAgregarListaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarListaDe.setFont(new Font("Bauhaus 93", Font.BOLD, 22));
		
		JLabel lblNewLabel = new JLabel("FORMATO:                            MATRICULA- NOMBRE- PROGRAMA- PLAN- UNIDAD- SEMESTRE- CORREO- TELEFONO ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEsperar, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAgregarListaDe, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE))))
					.addGap(24))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblAgregarListaDe, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEsperar, GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	public String[] cortarCadenaPorComas(String cadena) {
		  return cadena.split("\\,");
	}
}
