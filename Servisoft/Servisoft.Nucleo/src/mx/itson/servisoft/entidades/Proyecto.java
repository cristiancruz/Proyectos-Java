package mx.itson.servisoft.entidades;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Proyecto {
	private int id;
	private String nombreProyecto;
	private String tipoPrograma;
	private String sector;
	private String giro;
	private String empresa;
	private String telefono;
	private String contactoEmpresa;

	/**
	 * @return Devuelve el valor del atributo id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Devuelve el valor del atributo nombreProyecto
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo nombreProyecto
	 */
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	/**
	 * @return Devuelve el valor del atributo tipoPrograma
	 */
	public String getTipoPrograma() {
		return tipoPrograma;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo tipoPrograma
	 */
	public void setTipoPrograma(String tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}

	/**
	 * @return Devuelve el valor del atributo sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo sector
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @return Devuelve el valor del atributo giro
	 */
	public String getGiro() {
		return giro;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo giro
	 */
	public void setGiro(String giro) {
		this.giro = giro;
	}

	/**
	 * @return Devuelve el valor del atributo empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return Devuelve el valor del atributo telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return Devuelve el valor del atributo contactoEmpresa
	 */
	public String getContactoEmpresa() {
		return contactoEmpresa;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo contactoEmpresa
	 */
	public void setContactoEmpresa(String contactoEmpresa) {
		this.contactoEmpresa = contactoEmpresa;
	}
	public boolean guardar(String nombreProyecto, String tipoPrograma, String sector, String giro, String empresa, 
			String telefono, String contactoEmpresa)
	{
		Proyecto proyecto = new Proyecto();
		boolean exito = false;
		
		try{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			proyecto.setNombreProyecto(nombreProyecto);
			proyecto.setTipoPrograma(tipoPrograma);
			proyecto.setSector(sector);
			proyecto.setGiro(giro);
			proyecto.setEmpresa(empresa);
			proyecto.setTelefono(telefono);
			proyecto.setContactoEmpresa(contactoEmpresa);
			session.save(proyecto);
			transaction.commit();
			exito = true;
			session.close();
		}catch(Exception ex){
			System.out.println("Ocurrio un error " + ex);
		}
		
		return exito;
	}
	
	public Proyecto buscar(String nombre)
	{
		Proyecto proyecto = new Proyecto();
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Query query = session.createQuery("from Proyecto as p where p.nombreProyecto = :nombre");
			query.setParameter("nombre", nombre);
			proyecto = (Proyecto) query.uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return proyecto;
	}
	  public List listaProyectos()
			{
				List ls = null;
					try
					{
						Session session = HibernateUtilidad.getSessionFactory().openSession();
						Transaction transaction = null;
						transaction = session.beginTransaction();
						Query query = session.createQuery("from Proyecto");
						
						ls = query.list();
						transaction.commit();
					}
					catch(HibernateException ex)
					{
						System.out.println("Ocurrio un error durante la transaccion: " + ex);
					}		
				return ls;
			}
	  public List obtenerPorNombre(String nombre)
		{
		List list = null;
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Query query = session.createQuery("from Proyecto where nombreProyecto like '%" +nombre+"%'");
			
				list = query.list();
				transaction.commit();
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return  list;
		}
	  public List obtenerPorNombre2(String nombre)
		{
		List list = null;
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Query query = session.createQuery("from Proyecto where nombreProyecto like '%" +nombre+"%' or contactoEmpresa like '%"+nombre+"%'");
			
				list = query.list();
				transaction.commit();
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return  list;
		}
	  public Proyecto obtenerPorId(int id)
	  {
		  Proyecto p = null;
		  
		  try
		  {
			  Session session = HibernateUtilidad.getSessionFactory().openSession();
			  Query query = session.createQuery("from Proyecto where id= :id");
			  query.setParameter("id", id);
			  p = (Proyecto)query.uniqueResult();
		  }
		  catch(HibernateException ex)
		  {
			  System.out.println("Ocurrió un error durante la transacción " + ex);
		  }
		  return p;
	  }
}
