package Punto3;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {


    public void quicksort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(A,j+1,der);          // ordenamos subarray derecho

    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        long tiempo;

        Random rand = new Random();
        QuickSort quickSort = new QuickSort();

        int [] arrPru;

        //Pruebas desde tamaño 10 hasta 10000
        for (int i = 10; i <= 10000;i *= 10) {
            arrPru = new int[i];
            for (int j = 0; j < arrPru.length; j++) {
                arrPru[j] = rand.nextInt(i);
            }
            startTime = System.currentTimeMillis();
            quickSort.quicksort(arrPru,0,arrPru.length-1);
            endTime = System.currentTimeMillis();
            tiempo = endTime - startTime;
            System.out.print("Matriz post insertion: "+arrPru.length+" ");
            System.out.println(Arrays.toString(arrPru));
            System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");
        }

        //Pruebas desde tamaño 50 hasta 5000
        for (int i = 50; i <= 5000;i *= 10) {
            arrPru = new int[i];
            for (int j = 0; j < arrPru.length; j++) {
                arrPru[j] = rand.nextInt(i);
            }
            startTime = System.currentTimeMillis();
            quickSort.quicksort(arrPru,0,arrPru.length-1);
            endTime = System.currentTimeMillis();
            tiempo = endTime - startTime;
            System.out.print("Matriz post insertion: "+arrPru.length+" ");
            System.out.println(Arrays.toString(arrPru));
            System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");
        }

        //Pruebas de tamaño 2000
        arrPru = new int[2000];
        for (int j = 0; j < arrPru.length; j++) {
            arrPru[j] = rand.nextInt(2000);
        }
        startTime = System.currentTimeMillis();
        quickSort.quicksort(arrPru,0,arrPru.length-1);
        endTime = System.currentTimeMillis();
        tiempo = endTime - startTime;
        System.out.print("Matriz post insertion: "+arrPru.length+" ");
        System.out.println(Arrays.toString(arrPru));
        System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");
    }
}
