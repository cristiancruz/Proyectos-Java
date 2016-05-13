package mx.itson.servisoft.entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private String matricula;
	private String carrera;
	private String semestre;
	private String email;
	private String plan;
	private String campus;
	private String telefono;
	private String fecha;
	private int horas;
	private boolean papelera;

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
	 * @return Devuelve el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Devuelve el valor del atributo apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return Devuelve el valor del atributo matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return Devuelve el valor del atributo carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo carrera
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return Devuelve el valor del atributo semestre
	 */
	public String getSemestre() {
		return semestre;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo semestre
	 */
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	/**
	 * @return Devuelve el valor del atributo email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Devuelve el valor del atributo plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * @return Devuelve el valor del atributo campus
	 */
	public String getCampus() {
		return campus;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo campus
	 */
	public void setCampus(String campus) {
		this.campus = campus;
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
	 * @return Devuelve el valor del atributo horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo horas
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return Devuelve el valor del atributo papelera
	 */
	public boolean isPapelera() {
		return papelera;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo papelera
	 */
	public void setPapelera(boolean papelera) {
		this.papelera = papelera;
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean guardar(String nombre, String apellido, String matricula, String carrera, String semestre, 
			String email, String plan, String campus, String telefono, int horas, boolean papelera,String fecha)
	{
		Alumno alumno = new Alumno();
		boolean exito = false;
		
		try{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			alumno.setNombre(nombre);
			alumno.setApellido(apellido);
			alumno.setMatricula(matricula);
			alumno.setCarrera(carrera);
			alumno.setSemestre(semestre);
			alumno.setEmail(email);
			alumno.setPlan(plan);
			alumno.setCampus(campus);
			alumno.setTelefono(telefono);
			alumno.setHoras(0);
			alumno.setPapelera(false);
			alumno.setFecha(fecha);
			session.save(alumno);
			transaction.commit();
			exito = true;
			session.close();
		}catch(HibernateException ex){
			//System.out.println("Ocurrio un error " + ex);
		}
		
		return exito;
	}
	
	
//---------------------------------------------------------------------------------------------	
//---------------------------------------------------------------------------------------------
	public List obtenerAlumNormal(int papelera)
	{
	List list = null;
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Alumno where papelera like '%" +0+"%' and horas >= 500");
		
			list = query.list();
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			System.out.println("Ocurrió un error durante la transacción " + ex);
		}
		return  list;
	}
	
	//---------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------
	
	public List obtenerAlumEnPapelera(int papelera)
	{
	List list = null;
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Alumno where papelera like '%" +1+"%'");
		
			list = query.list();
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			System.out.println("Ocurrió un error durante la transacción " + ex);
		}
		return  list;
	}

	 public boolean liberarAlumno(int id,boolean papelera,String fecha)
		{
			boolean exito = false;
			
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Alumno alumno = (Alumno) session.get(Alumno.class, id);
				
				alumno.setPapelera(papelera);	
				alumno.setFecha(fecha);
				session.update(alumno);
				transaction.commit();
				exito = true;
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error al actualizar los datos " + ex); 
			}
			
			return exito;
		}
	 public List buscarPorApellido(String ape)
		{
		List list = null;
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Query query = session.createQuery("from Alumno where apellido like '%" +ape+"%' and papelera like 0");
			
				list = query.list();
				transaction.commit();
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return  list;
		}
	 public List<Alumno> buscar()
		{
				List<Alumno> alumnos = new ArrayList<Alumno>();
				try
				{
					Session session = HibernateUtilidad.getSessionFactory().openSession();
					Query query = session.createQuery("from Alumno");
				
					alumnos = query.list();
					
				}
				catch(HibernateException ex)
				{
					System.out.println("Ocurrió un error durante la transacción " + ex);
				}
				return alumnos;
		}
	 public Alumno obtenerPorId(int id)
		{
				Alumno alumno = new Alumno();
				try
				{
					Session session = HibernateUtilidad.getSessionFactory().openSession();
					Query query = session.createQuery("from Alumno as a where a.id = :id");
					query.setParameter("id", id);
					alumno = (Alumno)query.uniqueResult();
					
				}
				catch(HibernateException ex)
				{
					System.out.println("Ocurrió un error durante la transacción " + ex);
				}
				
				return alumno;
		}
	 public List buscarPorFecha(String fecha)
		{
		List list = null;
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Query query = session.createQuery("from Alumno where fecha like '%" +fecha+"%' and papelera like 1");
			
				list = query.list();
				transaction.commit();
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return  list;
		}
	 public List<Alumno> getAlumnos()
		{
			List<Alumno> alumnos = null;
			
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Query query = session.createQuery("from Alumno where papelera like 1" );		
				alumnos = query.list();
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			return alumnos;
		}
	 public List<Alumno> buscarPorNombre(String cadena)
		{
			List<Alumno> alumnos = new ArrayList<Alumno>();
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Query query = session.createSQLQuery("select id, nombre, apellido, matricula, carrera, semestre from alumno "
						+ "where nombre like '%"+cadena+"%' or apellido like '%"+cadena+"%'").setResultTransformer(Transformers.aliasToBean(Alumno.class));
			
				alumnos = query.list();
				
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return alumnos;
		}
	 public List<Alumno> buscarComo(String cadena)
		{
			List<Alumno> alumnos = new ArrayList<Alumno>();
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Query query = session.createSQLQuery("select id, nombre, apellido, matricula, carrera, semestre,email,plan,campus,telefono,horas,fecha from alumno "
						+ "where (nombre like '%"+cadena+"%' or apellido like '%"+cadena+"%' or fecha like '%"+cadena+"%') and papelera="+1).setResultTransformer(Transformers.aliasToBean(Alumno.class));
			
				alumnos = query.list();
				
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return alumnos;
		} 
	 public List<Alumno> buscarAlum(String cadena)
		{
			List<Alumno> alumnos = new ArrayList<Alumno>();
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Query query = session.createSQLQuery("select id, nombre, apellido, matricula, carrera, semestre,email,plan,campus,telefono,horas,fecha from alumno "
						+ "where nombre like '%"+cadena+"%' or apellido like '%"+cadena+"%'").setResultTransformer(Transformers.aliasToBean(Alumno.class));
			
				alumnos = query.list();
				
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return alumnos;
		} 
	 public List<Alumno> buscarComo2(String cadena)
		{
			List<Alumno> alumnos = new ArrayList<Alumno>();
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Query query = session.createSQLQuery("select id, nombre, apellido, matricula, carrera, semestre,email,plan,campus,telefono,horas from alumno "
						+ "where (nombre like '%"+cadena+"%' or apellido like '%"+cadena+"%' or horas like '%"+cadena+"%') and horas>=500 and papelera=0").setResultTransformer(Transformers.aliasToBean(Alumno.class));
			
				alumnos = query.list();
				
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return alumnos;
		} 
	 public boolean actualizarHoras(int id, int horas)
		{
			boolean exito = false;
			
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Alumno alumno = (Alumno) session.get(Alumno.class, id);
				alumno.setHoras(horas);
				session.update(alumno);
				transaction.commit();
				exito = true;
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
			}
			
			return exito;
		}
	 public boolean actualizar(String matricula , String carrera , String semestre, String email, String telefono)
		{
			boolean exito = false;
			
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Query query = session.createQuery("from Alumno where matricula= :matricula");
				query.setParameter("matricula", matricula);
				Alumno alumno = (Alumno)query.uniqueResult();
				alumno.setCarrera(carrera);
				alumno.setSemestre(semestre);
				alumno.setEmail(email);
				alumno.setTelefono(telefono);
				session.update(alumno);
				transaction.commit();
				exito = true;
				session.close();
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
			}
			
			return exito;
		}
}
