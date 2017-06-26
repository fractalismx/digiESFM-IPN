package com.company;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        int repeticiones=1000000;
        double suma=0;
        Inventarios inv=new Inventarios();

        for(int i=0;i<repeticiones;i++)
            suma+=inv.sistema(50,2,2);

        suma/=repeticiones;

        String resultado = "El promedio de costo es "+suma+"\n";

        JOptionPane.showMessageDialog(null,resultado,"resultado",JOptionPane.INFORMATION_MESSAGE);
    }
}
