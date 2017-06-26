/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminataaleatoria;

/**
 *
 * @author pablo
 */
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author pablo
 */
public class LecturaDatos
{

    //variables para los archivos
    private FileReader archivo;

    //variables de lectura
    private BufferedReader gestor;

    public LecturaDatos()
    {
        try
        {
            archivo = new FileReader(Principal.UBICACION + Principal.ARCHIVO);

            gestor = new BufferedReader(archivo);

            System.out.println("Lectura exitosa");
        }
        catch (FileNotFoundException fex)
        {
            System.out.println("No se puede abrir algún archivo \n" + fex);
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, fex);
        }
        catch (Exception ex)
        {
            System.out.println("Error desconocido \n" + ex);
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close()
    {
        try
        {
            archivo.close();
            gestor.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(LecturaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Double> numeros()
    {
        ArrayList<Double> lista = new ArrayList<>();
        boolean salir = false;
        String aux="";
        double auxiliar;
        StringTokenizer espacio;

            while (!salir)
            {

                try
                {
                    aux = gestor.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                if (aux != null)
                {
                    espacio = new StringTokenizer(aux, ",");

                    while (espacio.hasMoreElements())
                    {
                        String d = (String) espacio.nextElement();

                        auxiliar = Double.valueOf(d);

                        lista.add(auxiliar);
                    }

                }
                else
                {
                    salir = true;
                }

            }

        return lista;
    }

    @Override
    public String toString()
    {
        String aux;
        String l = "";
        boolean salir1 = false;
        //boolean salir2 = false;

        try
        {

            while (!salir1)//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
            {
                aux = gestor.readLine();
                //leemos una linea de texto y la guardamos en la variable auxiliar
                if (aux != null)
                {
                    l += aux + "\n";
                }
                else
                {
                    salir1 = true;
                }
            }

        }
        catch (IOException ioEx)
        {
            Logger.getLogger(LecturaDatos.class.getName()).log(Level.SEVERE, null, ioEx);
        }
        catch (Exception ex)
        {
            Logger.getLogger(LecturaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return l;
    }

}
