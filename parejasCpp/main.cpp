/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: pablo
 *
 * Created on 9 de junio de 2017, 12:59 PM
 */

#include <iostream> 
#include <cstdio>
#include <cstdlib>

using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int num, iter, camb, aux, cont;
int *PrefH;
int *PrefM;
int *LisPar;

void SecAle(int dim, int ind, int *pos)
{
    int i, k, a;
    long *Aux;

    Aux = (long*) malloc(dim * sizeof (long));

    for (i = 0; i <= dim - 1; i++) {
        *(Aux + i) = rand();
    }

    for (i = 0; i <= dim - 1; i++) {
        a = 0;
        for (k = 0; k <= dim - 1; k++) {
            if (*(Aux + k)>*(Aux + a)) {
                a = k;
            }
        }
        *(Aux + a) = -*(Aux + a);
        *(pos + ind * dim + i) = a;
    }

    free(Aux);
}

int main()
{

    int i, k;

    free(PrefM);
    free(PrefH);
    cout << "Hola!\n";
    cout << "Introduce el número de parejas de el modelo\n";
    cin>>num;
    cout << "Introduce el número de iteraciones para las parejas\n";
    cin>>iter;

    PrefM = (int*) malloc(num * num * sizeof (int));
    PrefH = (int*) malloc(num * num * sizeof (int));
    LisPar = (int*) malloc(num * sizeof (int));


    SecAle(num, 0, LisPar);

    for (i = 0; i <= num - 1; i++) {
        SecAle(num, i, PrefM);
        SecAle(num, i, PrefH);
    }



    /*Impresion tablas de preferencias*/
    for (i = 0; i <= num - 1; i++) {
        cout << "\n";
        cout << "Mujer" << i << "	";
        for (k = 0; k <= num - 1; k++) {

            {
                cout << "	" << *(PrefM + k + num * i);
            }

        }
    }

    std::cout << "\n\n\n";

    for (i = 0; i <= num - 1; i++) {
        cout << "\n";
        cout << "Hombre" << i << "	";
        for (k = 0; k <= num - 1; k++) {

            {
                cout << "	" << *(PrefH + k + num * i);
            }

        }
    }



    for (k = 1; k <= iter; k++) {
        cont = 0;
        cout << "\n\n Iteracion" << k << "\nParejas\n ";

        cout << "Mujer		Hombre\n";

        for (i = 0; i <= num - 1; i++) {
            cout << i << "		" << *(LisPar + i) << "\n";
        }

        for (i = 0; i <= num - 1; i++) {

            do {
                camb = rand() % (num);
            }
            while (camb == i);

            if ((*(PrefM + i * num + *(LisPar + i))>*(PrefM + i * num + *(LisPar + camb)))&&((*(PrefH + num * (*(LisPar + camb)) + camb))>(*(PrefH + num * (*(LisPar + camb)) + i)))) {
                aux = *(LisPar + i);
                *(LisPar + i) = *(LisPar + camb);
                *(LisPar + camb) = aux;
                cont = 1;
            }
            else {
                if ((*(PrefM + camb * num + *(LisPar + camb))>*(PrefM + camb * num + *(LisPar + i)))&&((*(PrefH + num * (*(LisPar + i)) + i))>(*(PrefH + num * (*(LisPar + i)) + camb)))) {
                    aux = *(LisPar + i);
                    *(LisPar + i) = *(LisPar + camb);
                    *(LisPar + camb) = aux;
                    cont = 1;
                }
            }
        }

        if (cont == 1) {
            cout << "\n Hubo cambio en el sistema\n";
        }
        else {
            cout << "\n El sistema permanecio estable\n";
        }
    }

    return 0;
}
