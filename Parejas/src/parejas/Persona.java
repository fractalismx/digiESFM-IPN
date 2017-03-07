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
public class Persona
{
    private int cantidad;
    private ArrayList<Integer> preferencias;
    private AlgoritmoP generador;
    private int enlace;
    
    
    public Persona(final int cantidad)
    {
       preferencias=new ArrayList<>();
       
       this.cantidad=cantidad;
       
       generador=new AlgoritmoP(cantidad);
       
       this.enlace=enlace;
    }
    
   /* public boolean verificarEmparejamiento()
    {
        boolean verif=true;
        
        for(int pref:preferencias)
        {
            if(pref>enlace)
            {
                verif=false;
            }
        }
        
        return verif;
    }*/
    
    public ArrayList<Integer> getPreferencias()
    {
        return preferencias;
    }
    
    public void setPreferencias(ArrayList<Integer> preferencias) 
    {
        this.preferencias = preferencias;
    }    
    
    public int getCantidad() 
    {
        return cantidad;
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    public AlgoritmoP getGenerador() 
    {
        return generador;
    }

    public void setGenerador(AlgoritmoP generador) 
    {
        this.generador = generador;
    }

    public int getEnlace() 
    {
        return enlace;
    }

    public void setEnlace(int enlace) 
    {
        this.enlace = enlace;
    }
    
    public void generarPreferencias()
    {
       preferencias=generador.acomodar();
    }
}
