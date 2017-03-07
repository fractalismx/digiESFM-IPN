/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parejas;

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
    private FileReader archivo1;
    private FileReader archivo2;

    //variables de lectura
    private BufferedReader gestor1;
    private BufferedReader gestor2;

    //ruta de archivos
    private final static String DIRECTORIO = "/home/pablo/digiESFM-IPN/";
    private final static String ARCHIVO1 = "parejas1.txt";
    private final static String ARCHIVO2 = "parejas2.txt";

    public FileReader getArchivo1()
    {
        return archivo1;
    }

    public FileReader getArchivo2()
    {
        return archivo2;
    }

    public BufferedReader getGestor1()
    {
        return gestor1;
    }

    public BufferedReader getGestor2()
    {
        return gestor2;
    }

    public LecturaDatos()
    {

        try
        {
            archivo1 = new FileReader(DIRECTORIO + ARCHIVO1);
            archivo2 = new FileReader(DIRECTORIO + ARCHIVO2);

            gestor1 = new BufferedReader(archivo1);
            gestor2 = new BufferedReader(archivo2);

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

    public void destructorLecturaDatos() throws IOException
    {
        archivo1.close();
        gestor1.close();

        archivo2.close();
        gestor2.close();
    }

    public ArrayList<Integer> numeros(BufferedReader gestor) throws IOException
    {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        boolean salir = false;
        String aux = "";
        int auxiliar;
        StringTokenizer espacio;

        while (!salir)
        {
            aux = gestor.readLine();

            if (aux != null)
            {
                espacio = new StringTokenizer(aux);

                while (espacio.hasMoreElements())
                {
                    String d = (String) espacio.nextElement();

                    auxiliar = Integer.valueOf(d);

                    lista.add(auxiliar);
                }

                //JOptionPane.showMessageDialog(null, lista.size());
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
        String aux = "";
        String l = "";
        boolean salir1 = false;
        boolean salir2 = false;

        try
        {

            while (!salir1)//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
            {
                aux = gestor1.readLine();
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

            l += "\n \n";

            while (!salir2)//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
            {
                aux = gestor2.readLine();
                //leemos una linea de texto y la guardamos en la variable auxiliar
                if (aux != null)
                {
                    l += aux + "\n";
                }
                else
                {
                    salir2 = true;
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
