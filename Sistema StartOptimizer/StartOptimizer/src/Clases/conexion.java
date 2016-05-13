package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author novutek
 */
public class conexion {
      Connection conect = null;
    

    public Connection conectar()
    {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            String user = "baseStartOptimizer";
            String pass = "151113";
            String db="jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=C:/dataStartOptimizer/baseStartOptimizer.mdb"; 
        try{
        
            Class.forName(driver);
            conect = DriverManager.getConnection(db,user,pass);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Base de datos no encontrada  "+ ex);
        }
        return conect; }
    
}
