/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parejas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pablo
 */
public class AlgoritmoP
{

    private int cantidad;
    private int arreglo[];
    private Random aleatorio;

    public AlgoritmoP(final int cantidad, final Random aleatorio)
    {
        this.cantidad = cantidad;
        this.arreglo = new int[this.cantidad];
        this.aleatorio = aleatorio;

        for (int i = 0; i < cantidad; i++)
        {
            this.arreglo[i] = i;
        }
    }

    public AlgoritmoP(final int cantidad)
    {
        this.cantidad = cantidad;
        this.arreglo = new int[this.cantidad];
        aleatorio = new Random();

        for (int i = 0; i < cantidad; i++)
        {
            this.arreglo[i] = i;
        }
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public Random getAleatorio()
    {
        return aleatorio;
    }

    public void setCantidad(final int cantidad)
    {
        this.cantidad = cantidad;
    }

    public void setAleatorio(Random aleatorio)
    {
        this.aleatorio = aleatorio;
    }

    public ArrayList<Integer> acomodar()
    {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int prueba = cantidad;
        int k, auxPosicion1, auxPosicion2;
        double u;
        
            for (int i = cantidad - 1; i >= 0; i--)
            {
                u = aleatorio.nextDouble();

                u = u * prueba;
                k = (int) u;

                auxPosicion1 = arreglo[i];
                auxPosicion2 = arreglo[k];

                arreglo[i] = auxPosicion2;
                arreglo[k] = auxPosicion1;
            }

            for (int h = 0; h < cantidad; h++)
            {
                lista.add(arreglo[h]);
            }
        
        return lista;
    }
}
