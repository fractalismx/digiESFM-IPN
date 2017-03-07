/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parejas;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Principal
{

    public final static int PAREJAS = 15;

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[])
    {
        
        Persona hombres[] = null;
        Persona mujeres[] = null;
        
        for (int i=0;i<PAREJAS;i++)
        {
            hombres[i]=new Persona(PAREJAS);
            mujeres[i]=new Persona(PAREJAS);
        }
        
        while()
        {
            
        }
        
    }

    //Codigo Lectura desde archivo
    /*
     * LecturaDatos lectura = new LecturaDatos();
     *
     * BufferedReader buffer1=lectura.getGestor1(); BufferedReader
     * buffer2=lectura.getGestor2();
     *
     * ArrayList<Integer> prueba1= lectura.numeros(buffer1); ArrayList<Integer>
     * prueba2= lectura.numeros(buffer2);
     *
     * lectura.destructorLecturaDatos();
     *
     * int matrizHombres[][]=new int[PAREJAS][PAREJAS]; int
     * matrizMujeres[][]=new int[PAREJAS][PAREJAS];
     *
     * int k=0;
     *
     * for(int i=0;i<PAREJAS;i++) { for(int j=0;j<PAREJAS;j++) {
     * matrizHombres[i][j]=prueba1.get(k); k++; } }
     *
     * k=0;
     *
     * for(int i=0;i<PAREJAS;i++) { for(int j=0;j<PAREJAS;j++) {
     * matrizMujeres[i][j]=prueba2.get(k); k++; }
             }
     */
}
