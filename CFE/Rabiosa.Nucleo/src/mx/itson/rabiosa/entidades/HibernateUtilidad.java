package mx.itson.rabiosa.entidades;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilidad {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	static{
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()).build();
			
			factory = configuration.buildSessionFactory(serviceRegistry);
		}catch(HibernateException ex){
			System.out.println("No se pudo crear la sesion de Hibernate" + ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return factory;
	}
}
