/**
 * @Author: Edwardo Calderon, Santiago Carrillo, Edwar Forero
 * @version: 1.0
 */

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
        int pivote=A[izq];
        int i=izq;
        int j=der;
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
            quicksort(A,izq,j-1);// ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(A,j+1,der);// ordenamos subarray derecho

    }
    /**
     * Método para ordenar un array, imprimirlo y mostrar el tiempo de ejecución
     *
     * @param tamano tamaño del array
     * @param numEjecuciones número de ejecuciones
     */
    public void ordenarYMostrarArray(int tamano, int numEjecuciones) {
        Random rand = new Random();

        while (numEjecuciones > 0) {
            System.out.println("Ejecución Numero: " + (4 - numEjecuciones) + "\n");
            numEjecuciones--;

            // Crear un array aleatorio de tamaño
            int[] array = new int[tamano];
            for (int i = 0; i < tamano; i++) {
                array[i] = rand.nextInt(1000); // Valores aleatorios entre 0 y 999
            }

            // Imprimir array desordenado (opcional)
            // System.out.println("Array desordenado de tamaño " + tamano + ": " + Arrays.toString(array));

            // Medir el tiempo de ejecución
            long startTime = System.nanoTime();

            // Ejecutar Quicksort
            quicksort(array, 0, array.length - 1);

            // Medir el tiempo transcurrido
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            // Imprimir array ordenado
            System.out.println("Array tamaño " + tamano + " ordenado " + "\n" + Arrays.toString(array));

            // Imprimir el tiempo transcurrido en segundos
            double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;

            // Imprime el tiempo de ejecución en segundos sin notación científica
            System.out.printf("Tiempo de ejecución: %.9f segundos", elapsedTimeInSeconds);
            System.out.println("\n");
        }
    }

    /**
     * Método main para ejecutar el programa
     *
     * @param args No se utiliza en este caso
     */
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        // Tamaños de entrada
        int[] tamanosEntrada = {10, 50, 100, 500, 1000, 2000, 5000, 10000};
        int numEjecuciones = 3;

        // Ejecutar el algoritmo para cada tamaño de entrada
        for (int tamano : tamanosEntrada) {
            qs.ordenarYMostrarArray(tamano, numEjecuciones);
        }
    }
}
