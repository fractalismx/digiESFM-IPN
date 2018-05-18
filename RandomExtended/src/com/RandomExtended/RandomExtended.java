package com.RandomExtended;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 *
 * @author pablo
 */
import java.util.*;

/**
 *
 * @author pablo
 */
public class RandomExtended extends Random
{

    public RandomExtended()
    {
        super();
    }

    public RandomExtended(final long seed)
    {
        super(seed);
    }

    public double nextGenerator(final ArrayList<Double> listNumbers, final ArrayList<Double> listProbability)
    {
        double suma = 0;
        double u = nextDouble();

        int i = 0;

        while (suma <= u)
        {
            suma += listProbability.get(i);
            i++;
        }

        return listNumbers.get(i);
    }

    public int nextBinomial(final int n, final double probability)
    {
        double suma = 0;
        int i = 0;
        double u = nextDouble();

        double auxiliarProbability = Math.pow(1 - probability, n);

        while (suma <= u)
        {
            suma += auxiliarProbability;
            auxiliarProbability *=  probability
            i++;
        }

        return i - 1;
    }

    public int nextPoisson(final double lambda)
    {
        double suma = 0;
        int i = 0;
        double u = nextDouble();

        double probability = Math.exp(-lambda);

        while (suma <= u)
        {
            suma += probability;
            probability *= lambda / (i + 1);
            i++;
        }

        return i - 1;
    }

    public int nextGeometric(final double probability)
    {
        double suma = 0;
        int i = 0;
        double u = nextDouble();

        double p1 = probability;

        while (suma <= u)
        {
            suma += p1;
            p1 *= (1 - probability);
            i++;
        }

        return i;
    }

    public double nextGaussian(final double mean, final double standardDesviation)
    {
        return mean + standardDesviation * super.nextGaussian();
    }

    public double nextExponential(final double lambda)
    {
        return Math.log(1.0/Math.pow(nextDouble(),1/lambda));
    }

    public double nextGamma(final double alpha)
    {
        double y = 0;
        double a = 0;
        double b = 0;
        double q = 0;
        double d = 0;
        double theta = 0;
        double p = 0;

        boolean bandera = true;

        if (alpha == 1)
            y = nextExponential(1);
        else if (alpha < 1)
        {
            b = (Math.E + alpha) / Math.E;

            do
            {
                p = b * nextDouble();

                if (p > 1)
                {
                    y = Math.log(alpha/(b-p));

                    if (nextDouble() <= Math.pow(y, alpha - 1.0))
                        bandera = false;
                }
                else
                {
                    y = Math.pow(p, 1.0 / alpha);

                    if (nextDouble() <= Math.exp(-y))
                        bandera=false;

                }
            } while (bandera);
        }
        else
        {
            a = 1.0 / Math.sqrt(2 * alpha - 1);
            b = alpha - Math.log(4);
            q = alpha + 1.0 / a;
            theta = 4.5;
            d = 1.0 + Math.log(theta);

            do
            {
                double u = nextDouble();
                double v = a * Math.log(u / (1 - u));
                y = alpha * Math.exp(v);
                double z = Math.pow(u,2.0) * nextDouble();
                double w = b + q * v - y;

                if (w + d - theta * z >= 0)
                    bandera = false;
                else if (w >= Math.log(z))
                    bandera = false;
                
            } while (bandera);

        }

        return y;
    }

    public double nextGamma(final double alpha, final double beta)
    {
        return beta * nextGamma(alpha);
    }

    public double nextXiSquare(final double degrees)
    {
        return 2*nextGamma(degrees/2);
    }

    public double nextFisherSnedecor(final double degrees1,final double degrees2)//duda
    {
        return (nextXiSquare(degrees1)*degrees2)/(nextXiSquare(degrees2)*degrees1);
    }
}
