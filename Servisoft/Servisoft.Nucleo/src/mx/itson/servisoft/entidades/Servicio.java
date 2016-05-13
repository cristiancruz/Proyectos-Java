package mx.itson.servisoft.entidades;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//private Programa programa;
public class Servicio {
	private int id;
	private Alumno alumno;
	private Proyecto proyecto;
	private String semestreRealizacion;
	private String duracion;
	private String horario;
	private int totalHoras;
	private boolean status;

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
	 * @return Devuelve el valor del atributo alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo alumno
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	 * @return Devuelve el valor del atributo proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo proyecto
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @return Devuelve el valor del atributo semestreRealizacion
	 */
	public String getSemestreRealizacion() {
		return semestreRealizacion;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo semestreRealizacion
	 */
	public void setSemestreRealizacion(String semestreRealizacion) {
		this.semestreRealizacion = semestreRealizacion;
	}

	/**
	 * @return Devuelve el valor del atributo duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return Devuelve el valor del atributo horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return Devuelve el valor del atributo totalHoras
	 */
	public int getTotalHoras() {
		return totalHoras;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo totalHoras
	 */
	public void setTotalHoras(int totalHoras) {
		this.totalHoras = totalHoras;
	}

	/**
	 * @return Devuelve el valor del atributo status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param Asigna
	 *            el valor al atributo status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public List<Servicio> buscarPorMatricula(String matricula)
	{
		List<Servicio> servicios = new ArrayList<Servicio>();
		
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Query query = session.createQuery("from Servicio as s where s.alumno.matricula = :matricula");
			query.setParameter("matricula", matricula);
			servicios = query.list();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return servicios;
	}
	
	public List<Servicio> buscarPorProyecto(int id)
	{
		List<Servicio> servicios = new ArrayList<Servicio>();
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Query query = session.createQuery("from Servicio as s where s.proyecto.id = :id");
			query.setParameter("id", id);
			
			servicios = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return servicios;
	}
	public List<Servicio> buscar()
	{
		List<Servicio> servicios = new ArrayList<Servicio>();
		
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Query query = session.createQuery("from Servicio");
			servicios = query.list();
		}
		catch(HibernateException e)
		{
			
		}
		
		return servicios;
	}
	public boolean guardar(String semestreRealizacion, String duracion , String horario, int totalHoras, boolean status, Alumno alumno, Proyecto proyecto)
	{
		boolean exito = false;
		Servicio servicio = new Servicio();
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			servicio.setSemestreRealizacion(semestreRealizacion);
			servicio.setDuracion(duracion);
			servicio.setHorario(horario);
			servicio.setTotalHoras(totalHoras);
			servicio.setStatus(status);
			servicio.setAlumno(alumno);
			servicio.setProyecto(proyecto);
			session.save(servicio);
			transaction.commit();
			exito = true;
			session.close();
		}
		catch(HibernateException e)
		{
			System.out.println(e);
		}
		
		return exito;
	}
	
	public List getSumaHoras()
	{
		
		List horas = new ArrayList();

		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			
			String hql = "select sum(s.totalHoras) from Servicio as s where s.status = true and s.alumno.id = s.alumno.id group by s.alumno.id";
			Query query = session.createQuery(hql);
			horas = query.list();
		}
		catch(HibernateException ex)
		{
			System.out.println(ex);
		}
		
		return horas;
	}
	
	//codigo cochino :c
	public List getIdAlumno()
	{
		List id = new ArrayList();
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			String hql = "select s.alumno.id from Servicio as s where s.status = true and s.alumno.id = s.alumno.id group by s.alumno.id";
			Query query = session.createQuery(hql);
			id = query.list();
			
		}
		catch(HibernateException ex)
		{
			System.out.println(ex);
		}
		return id;
	}
	public List<Servicio> buscarPorPeriodo(String periodo, String sector, String giro)
	{
		List<Servicio> servicios = new ArrayList<Servicio>();
		
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			
			Query query = session.createQuery("from Servicio as s where s.semestreRealizacion= :periodo  and s.proyecto.sector like :sector and s.proyecto.giro like :giro");
			query.setParameter("periodo", periodo);
			query.setParameter("sector", "%"+sector+"%");
			query.setParameter("giro", "%"+giro+"%");
			servicios = query.list();
		}
		catch(HibernateException e)
		{
			System.out.println(e);
		}
		
		return servicios;
	}
	public List<Servicio> buscarPorIdAlumno(int id)
	{
		List<Servicio> servicios = new ArrayList<Servicio>();
		
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Query query = session.createQuery("from Servicio as s where s.alumno.id= :id");
			query.setParameter("id", id);
			servicios = query.list();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return servicios;
	}
	public List obtenerSerEnProceso(int servicio)
	{
	List list = null;
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Servicio where status like '%" +0+"%'");
		
			list = query.list();
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			System.out.println("Ocurrió un error durante la transacción " + ex);
		}
		return  list;
	}
	 public boolean Actualizar(int id,boolean estado)
		{
			boolean exito = false;
			
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Servicio servicio  = (Servicio) session.get(Servicio.class, id);
				servicio.setStatus(true);
				session.update(servicio );
				transaction.commit();
				exito = true;
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error al actualizar los datos " + ex); 
			}
			
			return exito;
		}
}
