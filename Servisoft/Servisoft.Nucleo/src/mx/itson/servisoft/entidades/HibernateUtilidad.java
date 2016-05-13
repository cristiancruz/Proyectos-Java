package mx.itson.servisoft.entidades;


import javax.swing.JOptionPane;

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
			System.out.println("No se pudo crear la sesión de Hibernate" + ex);
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.\n"
					+ "1.-Cierre el sistema por completo.\n"
					+ "2.-Verifique tener corriendo mysql(xampp).\n"
					+ "3.-Habra de nuevo el sistema.");
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return factory;
	}
}
