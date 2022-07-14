/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminataaleatoria;

import com.RandomExtended.RandomExtended;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;

/**
 *
 * @author pablo
 */
public class EscrituraDatos {

    private File nuevo;
    private FileWriter archivo;
    private PrintWriter escribirArchivo;
    private RandomExtended aleat;

    public EscrituraDatos() {
        nuevo = new File(Principal.UBICACION + Principal.ARCHIVO);

        archivo = null;
        escribirArchivo = null;

        aleat = new RandomExtended();

        try {
            if (nuevo.createNewFile()) {
                System.out.println("File created: " + nuevo.getName());
            } else {
                System.out.println("File already exists.");
            }

            archivo = new FileWriter(nuevo);
            escribirArchivo = new PrintWriter(archivo);
        } catch (IOException ioEx) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ioEx);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escrituraWienerDrift() {
        Wiener wiener = new Wiener();

        double valorInicialNormal = 0;
        double tiempo = 0;

        int i;
        int j;

        for (i = 0; i < Principal.REPETICIONES; i++) {
            for (j = 0; j < Principal.PASOS; j++) {
                tiempo = i + j / Principal.PASOS;
                valorInicialNormal += Principal.MEDIA * tiempo + Principal.DESVIACIONSTD * wiener.numeroWiener(tiempo, aleat);

                if (valorInicialNormal < 0) {
                    valorInicialNormal = 0;
                }

                escribirArchivo.print(tiempo + "," + valorInicialNormal + "\n");
            }
        }

        tiempo += 1 / Principal.PASOS;
        valorInicialNormal += Principal.MEDIA1 * tiempo + Principal.DESVIACIONSTD1 * wiener.numeroWiener(tiempo, aleat);
        escribirArchivo.print(tiempo + "," + valorInicialNormal + "\n");
    }

    public void escrituraWiener() {
        Wiener wiener = new Wiener();
        double valorInicialNormal = 0;
        double tiempo = 0;

        int i;
        int j;

        for (i = 0; i < Principal.REPETICIONES; i++) {
            for (j = 0; j < Principal.PASOS; j++) {
                tiempo = i + j / Principal.PASOS;
                valorInicialNormal += wiener.numeroWiener(tiempo, aleat);

                if (valorInicialNormal < 0) {
                    valorInicialNormal = 0;
                }

                escribirArchivo.print(tiempo + "," + valorInicialNormal + "\n");
            }
        }

        tiempo += 1 / Principal.PASOS;
        valorInicialNormal += wiener.numeroWiener(tiempo, aleat);
        escribirArchivo.print(tiempo + "," + valorInicialNormal + "\n");
    }

    public void escrituraVolados() {
        int valorInicial = 0;
        ArrayList<Double> listaI = new ArrayList<Double>();

        listaI.add(-1.0);
        listaI.add(1.0);

        ArrayList<Double> listaD = new ArrayList<>();
        listaD.add(0.5);
        listaD.add(0.5);

        escribirArchivo.print("0," + valorInicial + "\n");

        for (int i = 0; i < Principal.REPETICIONES; i++) {
            valorInicial += aleat.nextGenerator(listaI, listaD);

            if (valorInicial < 0) {
                valorInicial = 0;
            }

            escribirArchivo.print(String.valueOf(i + 1) + "," + String.valueOf(valorInicial) + "\n");
        }

    }

    public void close() {
        try {
            archivo.close();
            escribirArchivo.close();
        } catch (IOException ioEx) {
            Logger.getLogger(EscrituraDatos.class.getName()).log(Level.SEVERE, null, ioEx);
        }
    }
}
