/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.rabiosa.entidades;

import java.util.List;			 

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Guarda el Iva, el Dap y el precio de kilowatts hora
 * @author CristianAlejandro
 */
public class Configuracion {
 private int id;
 private double iva;
 private double dap;
 private double precioKwHora;

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
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the dap
     */
    public double getDap() {
        return dap;
    }

    /**
     * @param dap the dap to set
     */
    public void setDap(double dap) {
        this.dap = dap;
    }

    /**
     * @return the precioKwHora
     */
    public double getPrecioKwHora() {
        return precioKwHora;
    }

    /**
     * @param precioKwHora the precioKwHora to set
     */
    public void setPrecioKwHora(double precioKwHora) {
        this.precioKwHora = precioKwHora;

    }
   
    /**
     * Obtiene un objeto de tipo Configuracion  y lo pasa a una lista
     * @return configuracion
     */
	public List<Configuracion> getConfiguracion()
	{
			
			List<Configuracion> configuracion = null;
		try{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Query query = session.createQuery("from Configuracion");	
			configuracion = query.list();
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return configuracion;
	}
	
   /**
    * Actualiza un objeto de tipo configuracion
    * @param id
    * @param iva
    * @param dap
    * @param precio
    * @return true o false
    */
    public boolean actualizar(int id , double iva, double dap, double precio)
	{
		boolean exito = false;
		
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Configuracion configuracion = (Configuracion) session.get(Configuracion.class, id);
			configuracion.setIva(iva);
			configuracion.setDap(dap);
			configuracion.setPrecioKwHora(precio);
			
			session.update(configuracion);
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

