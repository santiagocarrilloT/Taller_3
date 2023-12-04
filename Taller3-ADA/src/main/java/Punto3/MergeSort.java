/**
 * @Author: Edwardo Calderon, Santiago Carrillo, Edwar Forero
 * @version: 1.0
 */

package Punto3;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase MergeSort para ordenamiento de datos
 *
 */
public class MergeSort {
    /**
     * Metodo merge para ordanamiento de datos
     * @param arr array de enteros que se ordenara
     * @param l indice izquierdo, sirve para saber el tamaño del array
     * @param m indice medio, sirve para dividir el array
     * @param r indice derecho, sirve para saber el tamaño del array
     */
    void merge(int[] arr, int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Metodo sort para ordanamiento de datos
     * @param arr array de enteros que se ordenara
     * @param l indice izquierdo, sirve para saber el tamaño del array
     * @param r indice derecho, sirve para saber el tamaño del array
     */
    public void sort(int[] arr, int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
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
            //System.out.println("Array desordenado de tamaño " + tamano + ":\n " + Arrays.toString(array));

            // Medir el tiempo de ejecución
            long startTime = System.nanoTime();

            // Ejecutar Quicksort
            sort(array, 0, array.length - 1);

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
     * Metodo main para probar el ordenamiento
     * @param args imprime el tiempo de ejecución en segundos y la matriz ordenada
     */
    public static void main(String[] args)
    {   MergeSort ms = new MergeSort();

        // Tamaños de entrada
        int[] tamanosEntrada = {10, 50, 100, 500, 1000, 2000, 5000, 10000};
        int numEjecuciones = 3;

        // Ejecutar el algoritmo para cada tamaño de entrada
        for (int tamano : tamanosEntrada) {
            ms.ordenarYMostrarArray(tamano, numEjecuciones);
        }

    }
}
