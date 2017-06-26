package com.company;

import com.RandomExtended.RandomExtended;

/**
 * Created by pablo on 8/06/17.
 */
public class Inventarios
{
    public final static double TOTAL=270;
    public final static double LIMITE=500;

    private RandomExtended randomExtended;

    public Inventarios()
    {
        randomExtended=new RandomExtended();
    }

    /*public double genera(double tiempo,final double lambda)
    {
        return tiempo+randomExtended.nextExponential(lambda);
    }*/

    public Inventarios(RandomExtended randomExtended)
    {
        this.randomExtended = randomExtended;
    }

    public double sistema(final double inventarioCritico,final double lambda,final double lambda1)
    {
        String letrero = null;
        double C=LIMITE;
        double lapso=24;
        double tiempo=0;
        double tiempoLlegada=randomExtended.nextExponential(lambda);
        double vendidos=0;
        double noVendidos=0;
        double infi=TOTAL+1;

        double tiempoAnterior;

        double F=10;
        double a=1.5;
        double indicador=0;

        double precio=5;
        double r=0.01;
        double costoInventario=0;
        double costoOrdinario=F+a*LIMITE;
        double costoTotal=costoOrdinario;
        double tiempoReposicion=infi;

        //ArrayList<Double> lista=new ArrayList<>();
        //ArrayList<Double> listaTiempos=new ArrayList<>();

        while (tiempo<TOTAL)
        {
            //lista.add(C);
            //listaTiempos.add(tiempo);

            tiempoAnterior=tiempo;
            tiempo=Math.min(tiempoLlegada,tiempoReposicion);

            costoInventario+=(tiempo-tiempoAnterior)*C*r;

            if(tiempoLlegada<tiempoReposicion)
            {
                double pedido=randomExtended.nextPoisson(lambda1);

                if (C>=pedido)
                {
                    vendidos+=pedido;
                    C-=pedido;
                }
                else
                {
                    vendidos+=C;
                    noVendidos+=pedido-C;
                    C=0;
                }

                //letrero+=tiempoLlegada+" "+C+"\n";
                tiempoLlegada=tiempoLlegada+randomExtended.nextExponential(lambda);

                if(C<inventarioCritico && indicador==0)
                {
                    tiempoReposicion=lapso+tiempo;
                    indicador=1;
                    //letrero+="Se ordenan en "+tiempo+" con "+tiempoReposicion+"\n";
                }

            }
            else
            {
                costoOrdinario+=(LIMITE-C)+a*F;
                C=LIMITE;
                indicador=0;
                tiempoReposicion=infi;
                //letrero+="Se abastece en "+tiempo+" "+C+"\n";
            }

        }

        costoTotal=costoInventario+costoOrdinario;
        /*letrero="Costo = "+costoTotal+"\n";
        letrero+="Vendidos = "+vendidos+"\n";
        letrero+="No vendidos = "+noVendidos+"\n";
        letrero+="Ganancia = "+String.valueOf(vendidos*precio-costoTotal)+"\n";*/

        return costoTotal;
    }
}
