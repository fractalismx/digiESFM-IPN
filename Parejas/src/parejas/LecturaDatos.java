/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parejas;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */

public class LecturaDatos
{
    private StringTokenizer prueba;
    
    //variables para los archivos
    private FileReader archivo1;
    private FileReader archivo2;
    
    //variables de lectura
    private BufferedReader gestor1;
    private BufferedReader gestor2;
    
    //ruta de archivos
    private final static String DIRECTORIO="/home/pablo/";
    private final static String ARCHIVO1="parejas1.txt";
    private final static String ARCHIVO2="parejas2.txt";
    
    public LecturaDatos()
    {
        prueba = new StringTokenizer(" ");
        
        try
        {
            archivo1=new FileReader(DIRECTORIO+ARCHIVO1);
            archivo2=new FileReader(DIRECTORIO+ARCHIVO2);
            
            gestor1=new BufferedReader(archivo1);
            gestor2=new BufferedReader(archivo2);
            System.out.println("Lectura exitosa");
        }
        catch (FileNotFoundException fex)
        {
            System.out.println("No se puede abrir algún archivo \n"+fex);
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, fex);
        }
        catch (Exception ex)
        {
            System.out.println("Error desconocido \n"+ex);
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destructorLecturaDatos() throws IOException
    {
        archivo1.close();
        gestor1.close();
        
        archivo2.close();
        gestor2.close();
    }
    
    @Override
    public String toString()
    {
        
      String aux="",l="";
      
      try
      {
            
        while(true)//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
	{
	    aux=gestor1.readLine();
	    //leemos una linea de texto y la guardamos en la variable auxiliar
	    if(aux!=null)
               l+=aux+"\n";
	    else
	       break;
        }
        
        l+="\n \n";
        
         while(true)//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
	{
	    aux=gestor2.readLine();
	    //leemos una linea de texto y la guardamos en la variable auxiliar
	    if(aux!=null)
               l+=aux+"\n";
	    else
	       break;
        }
      }
      catch (IOException ex)
      {
        Logger.getLogger(LecturaDatos.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        return l;
    }
    
    
}
