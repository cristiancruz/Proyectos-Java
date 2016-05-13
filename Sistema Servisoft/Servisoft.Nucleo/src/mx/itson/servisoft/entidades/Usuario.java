package mx.itson.servisoft.entidades;

import java.util.Iterator;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class Usuario {
	private int id;
	private String usuario;
	private String pass;
	private String tipoUsuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	 public Usuario obtenerPorId(int index)
		{
		 Usuario usuario = new Usuario();
				try
				{
					Session session = HibernateUtilidad.getSessionFactory().openSession();
					Transaction transaction = null;
					transaction = session.beginTransaction();
					Query query = session.createQuery("from Usuario where id = :id");
					query.setParameter("id", index);
					
					usuario = (Usuario) query.uniqueResult();
					transaction.commit();
				}
				catch(HibernateException ex)
				{
					System.out.println("Ocurrio un error durante la transaccion: " + ex);
				}

				return usuario;
		}
	 public boolean acceso(String name, String password) {
		 Session session = HibernateUtilidad.getSessionFactory().openSession();
		 String SQL_QUERY = " from Usuario u where u.usuario='" + name + "' and u.pass='" + password + "'";

		 Query query = session.createQuery(SQL_QUERY);
		 Iterator<Usuario> it = query.iterate();
		 List<Usuario> list = query.list();
		 if (list.size() > 0) {
			 //CORRECTO
			 return true;
		 }
		 return false;
	 }
	 public List listaUser(){
			List ls = null;
				try
				{
					Session session = HibernateUtilidad.getSessionFactory().openSession();
					Transaction transaction = null;
					transaction = session.beginTransaction();
					Query query = session.createQuery("from Usuario");
					
					ls = query.list();
					transaction.commit();
				}
				catch(HibernateException ex)
				{
					System.out.println("Ocurrio un error durante la transaccion: " + ex);
				}		
			return ls;
		}

	 public boolean Actualizar(int id,String Pass)
		{
			boolean exito = false;
			
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Usuario usuario = (Usuario) session.get(Usuario.class, id);
				usuario.setPass(Pass);
				session.update(usuario);
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


