package caminataaleatoria;

import com.RandomExtended.RandomExtended;

/**
 * Created by pablo on 3/04/17.
 */
public class Wiener
{
    public Wiener()
    {

    }

    public double numeroWiener(final double tiempo, final RandomExtended aleat)
    {
        return aleat.nextGaussian(Principal.MEDIA, Math.sqrt(tiempo)*Principal.DESVIACIONSTD);
    }
}
