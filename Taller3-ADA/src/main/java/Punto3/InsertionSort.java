/**
@Author: Edwardo Calderon, Santiago Carrillo, Edwar Forero
@version: 1.0
 */
package Punto3;

import java.util.Arrays;
import java.util.Random;
/*
Clase InsertionSort para ordenamiento de datos
 */
public class InsertionSort {
    /**
    Metodo InsertionSort para ordanamiento de datos
    @param arr corresponde al arreglo que será ordenado
     */
    void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
            // System.out.println("Array desordenado de tamaño " + tamano + ": " + Arrays.toString(array));

            // Medir el tiempo de ejecución
            long startTime = System.nanoTime();

            // Ejecutar Quicksort
            sort(array);

            // Medir el tiempo transcurrido
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            // Imprimir array ordenado
            System.out.println("Array tamaño " + tamano + " ordenado " + "\n" );

            // Imprimir el tiempo transcurrido en segundos
            double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;

            // Imprime el tiempo de ejecución en segundos sin notación científica
            System.out.printf("Tiempo de ejecución: %.9f segundos", elapsedTimeInSeconds);
            System.out.println("\n");
        }
    }

    /**
     * Metodo main para probar el ordenamiento
     * @param args Imprime el tiempo de ejecución en segundos y la matriz ordenada
     */
    public static void main(String args[]) {
        InsertionSort is = new InsertionSort();

        // Tamaños de entrada
        int[] tamanosEntrada = {10, 50, 100, 500, 1000, 2000, 5000, 10000};
        int numEjecuciones = 3;

        // Ejecutar el algoritmo para cada tamaño de entrada
        for (int tamano : tamanosEntrada) {
            is.ordenarYMostrarArray(tamano, numEjecuciones);
        }
    }
}
