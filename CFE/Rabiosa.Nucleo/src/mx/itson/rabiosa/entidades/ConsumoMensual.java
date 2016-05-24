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
 *Son los recibos de luz / Consumos mensuales.
 * @author CristianAlejandro
 */
public class ConsumoMensual {
    private int id;
    private int idCliente;
    private String nombreCliente;
    private double kilowatts;
    private int mes;
    private int año;
    private double adeudo;
    private double subtotal;
    private double total;

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
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
     * @return the kilowatts
     */
    public double getKilowatts() {
        return kilowatts;
    }

    /**
     * @param kilowatts the kilowatts to set
     */
    public void setKilowatts(double kilowatts) {
        this.kilowatts = kilowatts;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the aÃ±o
     */
    public int getAño() {
        return año;
    }

    /**
     * @param aÃ±o the aÃ±o to set
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

	public double getAdeudo() {
		return adeudo;
	}

	public void setAdeudo(double adeudo) {
		this.adeudo = adeudo;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	/**
	 * Guardar un objeto ConsumoMensual
	 * @param idCliente
	 * @param nombreCliente
	 * @param kw
	 * @param mes
	 * @param año
	 * @param adeudo
	 * @param subTotal
	 * @param total
	 * @return true o false
	 */
	public boolean guardar (int idCliente,String nombreCliente, double kw, int mes, int año, double adeudo, double subTotal, double total)
	{
		ConsumoMensual con = new ConsumoMensual();
		boolean exito = false;
		
		try{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			con.setIdCliente(idCliente);
			con.setNombreCliente(nombreCliente);
			con.setKilowatts(kw);
			con.setMes(mes);
			con.setAño(año);
			con.setAdeudo(adeudo);
			con.setSubtotal(subTotal);
			con.setTotal(total);
			session.save(con);
			transaction.commit();
			exito = true;
		} catch(Exception ex) {
			System.out.println("Ocurrio un error " + ex);
		}
		return exito;
	}
	/**
	 * Guarda todos los objetos ConsumoMensual encontrados en una lista
	 * @return lista
	 */
	public List Consumos() {
    	List ls = null;
		try {
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Query query = session.createQuery("from ConsumoMensual");
			
			ls = query.list();
			transaction.commit();
		} catch(HibernateException ex) {
			System.out.println("Ocurrio un error durante la transaccion: " + ex);
		}		
	return ls;
    }
	/**
	 * Busca un objeto de tipo consumoMensual por nombre y lo guarda en una lista
	 * @param nombre
	 * @return lista
	 */
	public List obtenerPorNombre(String nombre)
		{
		List list = null;
			try
			{
				Session session = HibernateUtilidad.getSessionFactory().openSession();
				Transaction transaction = null;
				transaction = session.beginTransaction();
				Query query = session.createQuery("from ConsumoMensual where nombreCliente like '%" +nombre+"%'");
			
				list = query.list();
				transaction.commit();
			}
			catch(HibernateException ex)
			{
				System.out.println("Ocurrió un error durante la transacción " + ex);
			}
			return  list;
		}

	/**
	 * Busca un objeto de tipo consumoMensual por mes y lo guarda en una lista
	 * @param mes
	 * @return lista
	 */
	public List obtenerPorMes(int mes)
	{
	List list = null;
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Query query = session.createQuery("from ConsumoMensual where mes like '%" +mes+"%'");
		
			list = query.list();
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			System.out.println("Ocurrió un error durante la transacción " + ex);
		}
		return  list;
	}
	
	/**
	 * Busca un objeto de tipo consumoMensual por año y lo guarda en una lista
	 * @param año
	 * @return lista
	 */
	public List obtenerPorAño(int año)
	{
	List list = null;
		try
		{
			Session session = HibernateUtilidad.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			Query query = session.createQuery("from ConsumoMensual where año like '%" +año+"%'");
		
			list = query.list();
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			System.out.println("Ocurrió un error durante la transacción " + ex);
		}
		return  list;
	}
	
}
