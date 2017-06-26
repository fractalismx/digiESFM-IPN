/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminataaleatoria;
import com.panayotis.gnuplot.*;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.*;
import java.util.ArrayList;


/**
 *
 * @author pablo
 */
public class Principal
{
    public static final int REPETICIONES=30;
    public static final double PASOS=10;
    public static final double MEDIA=0;
    public static final double DESVIACIONSTD=1;
    public static final double MEDIA1=1;
    public static final double DESVIACIONSTD1=0.1;
    public static final String UBICACION="/home/pablo/";
    public static final String ARCHIVO="proceso.csv";
    public static final String ETIQUETAX="'tiempo'";
    public static final String ETIQUETAY="'ganancia'";
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
       EscrituraDatos escribir=new EscrituraDatos();
       JavaPlot p=new JavaPlot();
       
       //escribir.escrituraVolados();
       escribir.escrituraWienerDrift();
       
       escribir.close();
       
       LecturaDatos leer = new LecturaDatos();
       
       int valores = (int) PASOS*REPETICIONES+1;
       
       double movimiento[][]=new double [valores][2];
       
       ArrayList<Double> brownNormal=leer.numeros();
       
       System.out.println(brownNormal.size());
       
       int k=0;
       
       for(int i=0;i<valores;i++) 
       { 
           for(int j=0;j<2;j++) 
           {
               movimiento[i][j]=brownNormal.get(k); 
               k++;
           } 
       }
       
       leer.close();
       
       PlotStyle estilo = new PlotStyle();
       estilo.setStyle(Style.LINES);
       estilo.setLineType(NamedPlotColor.GOLD);
       
       DataSetPlot settear = new DataSetPlot(movimiento);
       settear.setPlotStyle(estilo);
       
       p.addPlot(settear);
       p.setTitle("Caminata Aleatoria", "Times New Roman", 12);
       
       GNUPlotParameters param=p.getParameters();
       
       param.set("xlabel",ETIQUETAX);
       param.set("ylabel",ETIQUETAY);
       param.set("grid");
       
       p.setParameters(param);
       
       p.plot();
       
    }
    
}
