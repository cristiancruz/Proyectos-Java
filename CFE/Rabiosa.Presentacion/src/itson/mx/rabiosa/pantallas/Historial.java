package itson.mx.rabiosa.pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import mx.itson.rabiosa.entidades.ConsumoMensual;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Historial extends JFrame {

	public JPanel contentPane;
	ConsumoMensual consumoMensual = new ConsumoMensual();
	JScrollPane scrollPane = new JScrollPane();
	DefaultTableModel modelo = new DefaultTableModel();
	JTable tab = new JTable();
	public JTextField txtBusqueda;
	JComboBox cbxBusqeda = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historial frame = new Historial();
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
	
	public void tablaEntera(){
		//LLENADO TABLA
				List<ConsumoMensual> listaConsumos = consumoMensual.Consumos();
				tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String Titulos[] = { "ID Cliente","Nombre Cliente", "Mes", "Año", "Total"};
				modelo = new DefaultTableModel(new Object[0][0], Titulos);
		//recorremos para obtener la info de la lista
				for(int i=0; i<listaConsumos.size(); i++) {
					Object[] o = new Object[5];//pq son 5 titulos y se necesitan 5 espacios que llenar por fila
		//condiciones para asignar nombres a los meses y no numeros
					if (listaConsumos.get(i).getMes()==1){

						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Enero";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}else if(listaConsumos.get(i).getMes()==2){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Febrero";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}else if(listaConsumos.get(i).getMes()==3){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Marzo";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}else if(listaConsumos.get(i).getMes()==4){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Abril";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}else if(listaConsumos.get(i).getMes()==5){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Mayo";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
					else if(listaConsumos.get(i).getMes()==6){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Junio";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}else if(listaConsumos.get(i).getMes()==7){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Julio";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
					else if(listaConsumos.get(i).getMes()==8){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Agosto";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
					else if(listaConsumos.get(i).getMes()==9){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Septiembre";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
					else if(listaConsumos.get(i).getMes()==10){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Octubre";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
					else if(listaConsumos.get(i).getMes()==11){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Nov";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
					if(listaConsumos.get(i).getMes()==12){
						o[0] = listaConsumos.get(i).getIdCliente();
						o[1] = listaConsumos.get(i).getNombreCliente();
						o[2] = "Diciembre";
						o[3] = listaConsumos.get(i).getAño();
						o[4] = listaConsumos.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						tab.setModel(modelo);
						scrollPane.setViewportView(tab);
					}
				}
					//--------------------FIN LLENADO TABLA DE INICIO------------------------------------	

			
		
	}
	public void busqedas(){
		//busqeda por nombre, mes o año

		if(cbxBusqeda.getSelectedItem()=="NOMBRE"){
			consumoMensual.obtenerPorNombre(txtBusqueda.getText());
			
			List<ConsumoMensual> lClientes =consumoMensual.obtenerPorNombre(txtBusqueda.getText());
			
			JTable tab = new JTable();
			tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			String Titulos[] = {"ID Cliente","Nombre Cliente", "Mes", "Año", "Total"};
			modelo = new DefaultTableModel(new Object[0][0], Titulos);
			
		for(int i=0; i<lClientes.size(); i++) {
				Object[] o = new Object[5];
				if (lClientes.get(i).getMes()==1){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Enero";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==2){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Febrero";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}
				else if(lClientes.get(i).getMes()==3){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Marzo";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==4){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Abril";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==5){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Mayo";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==6){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Junio";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==7){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Julio";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==8){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Agosto";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==9){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "sep";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==10){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Oct";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}else if(lClientes.get(i).getMes()==11){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Nov";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				} if(lClientes.get(i).getMes()==12){

					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = "Diciembre";
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);
					tab.setAutoCreateRowSorter(true);
					tab.setModel(modelo);
					scrollPane.setViewportView(tab);
				}
			}	
		}//cierre primer cbx	
		tab.setModel(modelo);
		scrollPane.setViewportView(tab);
		if(cbxBusqeda.getSelectedItem()=="MES"){
				consumoMensual.obtenerPorMes(Integer.parseInt(txtBusqueda.getText()));
			
			List<ConsumoMensual> lClientes =consumoMensual.obtenerPorMes(Integer.parseInt(txtBusqueda.getText()));
			JTable tab = new JTable();
			tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			String Titulos[] = {"ID Cliente","Nombre Cliente", "Mes", "Año", "Total"};
			modelo = new DefaultTableModel(new Object[0][0], Titulos);

			for(int i=0; i<lClientes.size(); i++) {
					Object[] o = new Object[5];	
						o[0] = lClientes.get(i).getIdCliente();
						o[1] = lClientes.get(i).getNombreCliente();
						o[2] = lClientes.get(i).getMes();
						o[3] = lClientes.get(i).getAño();
						o[4] = lClientes.get(i).getTotal();   
						modelo.addRow(o);
						tab.setAutoCreateRowSorter(true);
						
		}
			tab.setModel(modelo);
			scrollPane.setViewportView(tab);
			
		}	//cierre segundo cbs
		if(cbxBusqeda.getSelectedItem()=="AÑO"){
			consumoMensual.obtenerPorAño(Integer.parseInt(txtBusqueda.getText()));
		
		List<ConsumoMensual> lClientes =consumoMensual.obtenerPorAño(Integer.parseInt(txtBusqueda.getText()));
		JTable tab = new JTable();
		tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String Titulos[] = {"ID Cliente","Nombre Cliente", "Mes", "Año", "Total"};
		modelo = new DefaultTableModel(new Object[0][0], Titulos);

		for(int i=0; i<lClientes.size(); i++) {
				Object[] o = new Object[5];	
					o[0] = lClientes.get(i).getIdCliente();
					o[1] = lClientes.get(i).getNombreCliente();
					o[2] = lClientes.get(i).getMes();
					o[3] = lClientes.get(i).getAño();
					o[4] = lClientes.get(i).getTotal();   
					modelo.addRow(o);			
					tab.setAutoCreateRowSorter(true);
	}
		tab.setModel(modelo);
		scrollPane.setViewportView(tab);
	}	
	
	}
	public Historial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(31, 148, 654, 251);
		contentPane.add(scrollPane);
		cbxBusqeda.setModel(new DefaultComboBoxModel(new String[] {"NOMBRE", "MES", "A\u00D1O"}));
		cbxBusqeda.setBounds(49, 67, 101, 20);
		contentPane.add(cbxBusqeda);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(160, 67, 86, 20);
		contentPane.add(txtBusqueda);
		
		JButton btnVerListaEntera = new JButton(" Lista completa");
		btnVerListaEntera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaEntera();
			}
		});
		btnVerListaEntera.setBounds(371, 66, 314, 23);
		contentPane.add(btnVerListaEntera);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				busqedas();
			}
			
			});
		btnBuscar.setBounds(256, 66, 89, 23);
		contentPane.add(btnBuscar);
	
		tablaEntera();
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui a= new Gui();
				a.setVisible(true);
				Historial.this.setVisible(false);
			}
		});
		
		btnRegresar.setBounds(534, 418, 147, 23);
		contentPane.add(btnRegresar);
		
	
	
	}
	
	
	
}
