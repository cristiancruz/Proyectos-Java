package mx.itson.servisoft.entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;
public class crearexcel {
	  public void CreateExcel(DefaultTableModel model) {
		    
		    javax.swing.JFileChooser j = new javax.swing.JFileChooser(); 
		    j.showSaveDialog(j); 
		   
		    try { 
		        File f = new File(j.getSelectedFile().getAbsolutePath()); 
		        FileWriter fw = new FileWriter(f + ".csv"); 
		        BufferedWriter bw = new BufferedWriter(fw); 
		        PrintWriter salida = new PrintWriter(bw); 
		        String data[][] = ObtenerDatos(model); 
		        for (int i = 0; i < data.length; i++) { 
		            salida.print(data[i][0]); 
		            for (int jj = 1; jj < data[i].length; jj++) 
		            { String texto = data[i][jj]; 
		            if (texto != null) { 
		                salida.print("," + texto); 
		            } else { 
		                salida.print(","); 
		            } } 
		            salida.println(); 
		        } salida.close(); 
		    } 
		    catch (IOException e) { } }
		    
		    
		      public String[][] ObtenerDatos(DefaultTableModel modelo){
		        int numFilas=modelo.getRowCount();
		        int numColumnas=modelo.getColumnCount();
		        boolean  isCaptureTheTitles=false;
		        String matriz[][] = new String[numFilas + 1 ][numColumnas]; 
		        for (int rowIndex = 0; rowIndex < numFilas; rowIndex++) { 
		            for (int col = 0; col < numColumnas; col++) { 
		               if(!isCaptureTheTitles){
		               matriz[0][col]=modelo.getColumnName(col);
		               isCaptureTheTitles=(rowIndex>0)?true:false;
		               }
		               matriz[rowIndex + 1][col]=(String) modelo.getValueAt(rowIndex, col);
		            } 
		        } 
		        return matriz;
		    }
}
