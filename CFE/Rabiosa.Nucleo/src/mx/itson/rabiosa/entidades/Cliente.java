package mx.itson.rabiosa.entidades;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * Es el cliente
 * @author CristianAlejandro
 *
 */
public class Cliente {
	 private int id;
	    private String nombre;
	    private String apellido;
	    private String direccion;
	    private String telefono;
	    private String cp;
	    private int numeroContrato;
	    private int numeroMedidor;

	    /**
	     * @return the id
	     */
	    public int getId() {
	        return id;
	    }

	    /**
	     * @param id the id to set
	     */
	    public void setId(int id) {
	        this.id = id;
	    }

	    /**
	     * @return the nombre
	     */
	    public String getNombre() {
	        return nombre;
	    }

	    /**
	     * @param nombre the nombre to set
	     */
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    /**
	     * @return the apellido
	     */
	    public String getApellido() {
	        return apellido;
	    }

	    /**
	     * @param apellido the apellido to set
	     */
	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    /**
	     * @return the direccion
	     */
	    public String getDireccion() {
	        return direccion;
	    }

	    /**
	     * @param direccion the direccion to set
	     */
	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    /**
	     * @return the telefono
	     */
	    public String getTelefono() {
	        return telefono;
	    }

	    /**
	     * @param telefono the telefono to set
	     */
	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    /**
	     * @return the cp
	     */
	    public String getCp() {
	        return cp;
	    }

	    /**
	     * @param cp the cp to set
	     */
	    public void setCp(String cp) {
	        this.cp = cp;
	    }

	    /**
	     * @return the numeroContrato
	     */
	    public int getNumeroContrato() {
	        return numeroContrato;
	    }

	    /**
	     * @param numeroContrato the numeroContrato to set
	     */
	    public void setNumeroContrato(int numeroContrato) {
	        this.numeroContrato = numeroContrato;
	    }

	    /**
	     * @return the numeroMedidor
	     */
	    public int getNumeroMedidor() {
	        return numeroMedidor;
	    }

	    /**
	     * @param numeroMedidor the numeroMedidor to set
	     */
	    public void setNumeroMedidor(int numeroMedidor) {
	        this.numeroMedidor = numeroMedidor;
	    }
	   
	   /**
	    * Guardar un objeto cliente
	    * @param nombre
	    * @param apellido
	    * @param direccion
	    * @param telefono
	    * @param cp
	    * @param numeroContrato
	    * @param numeroMedidor
	    * @return true o false
	    */
		public boolean guardar (String nombre, String apellido, String direccion,String telefono, String cp,int numeroContrato, int numeroMedidor)
		{
			Cliente cliente = new Cliente();
			boolean exito = false;
			
			try{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setDireccion(direccion);
				cliente.setTelefono(telefono);
				cliente.setCp(cp);
	            cliente.setNumeroContrato(numeroContrato);
				cliente.setNumeroMedidor(numeroMedidor);
				session.save(cliente);
				transaction.commit();
				exito = true;
			}catch(Exception ex){
				System.out.println("Ocurrio un error " + ex);
			}
			
			return exito;
		}
	        
	       
		/**
		 * busca un objeto cliente  mediante un index
		 * @param index
		 * @return objeto cliente
		 */
	        public Cliente obtenerPorId(int index)
		{
			Cliente cliente = new Cliente();
				try
				{
					Session session = HibernateUtilidad.getSessionFactory().openSession();
					Transaction transaction = null;
					transaction = session.beginTransaction();
					Query query = session.createQuery("from Cliente where id = :id");
					query.setParameter("id", index);
					
					cliente = (Cliente) query.uniqueResult();
					transaction.commit();
				}
				catch(HibernateException ex)
				{
					System.out.println("Ocurrio un error durante la transaccion: " + ex);
				}
			
			return cliente;
		}
	        
	      
	        /**
	         * Guarda todos los objetos cliente encontrados en una lista
	         * @return lista
	         */
	        public List listaClientes()
		{
			List ls = null;
				try
				{
					Session session = HibernateUtilidad.getSessionFactory().openSession();
					Transaction transaction = null;
					transaction = session.beginTransaction();
					Query query = session.createQuery("from Cliente");
					
					ls = query.list();
					transaction.commit();
				}
				catch(HibernateException ex)
				{
					System.out.println("Ocurrio un error durante la transaccion: " + ex);
				}		
			return ls;
		}
	        
	
}
