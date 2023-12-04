package Punto3;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    /**
     * Metodo quicksort para ordenar un array de enteros
     * @param A array de enteros
     * @param izq indice izquierdo
     * @param der indice derecho
     */
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
    /**
     * Metodo main para ejecutar el programa
     *
     */

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        Random rand = new Random();

        // Tamaños de entrada
        int[] tamanosEntrada = {10, 50, 100, 500, 1000, 2000, 5000, 10000};
        int numEjecuciones = 3;
        // Ejecutar el algoritmo para cada tamaño de entrada
        while (numEjecuciones > 0) {
            System.out.println("Ejecución Numero: " + (4 - numEjecuciones) + "\n");
            numEjecuciones--;
            for (int tamano : tamanosEntrada) {
                // Crear un array aleatorio de tamaño
                int[] array = new int[tamano];
                for (int i = 0; i < tamano; i++) {
                    array[i] = rand.nextInt(1000); // Valores aleatorios entre 0 y 999
                }

                // Imprimir array desordenado
                System.out.println("Array desordenado de tamaño " + tamano + ": " + Arrays.toString(array));

                // Medir el tiempo de ejecución
                long startTime = System.nanoTime();

                // Ejecutar Quicksort
                qs.quicksort(array, 0, array.length - 1);

                // Medir el tiempo transcurrido
                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;

                // Imprimir array ordenado
                System.out.println("Array ordenado: " + Arrays.toString(array));

                // Imprimir el tiempo transcurrido en segundos
                System.out.println("Tiempo transcurrido: " + (double) elapsedTime + " milisegundos\n");
            }

        }

    }
}
