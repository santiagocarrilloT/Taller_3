package Punto3;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
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

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    /*static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }*/

    // Driver code
    public static void main(String[] args)
    {
        /*long startTime;
        long endTime;
        long tiempo;*/

        Random rand = new Random();
        MergeSort mergeSort = new MergeSort();
        //int [] arrPru;
        // Tamaños de entrada
        int[] tamanosEntrada = {10, 50, 100, 500, 1000, 2000, 5000, 10000};
        int numEjecuciones = 3;

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
                //System.out.println("Array desordenado de tamaño " + tamano + ": " + Arrays.toString(array));

                // Medir el tiempo de ejecución
                long startTime = System.nanoTime();

                // Ejecutar InsertionSort
                mergeSort.sort(array, 0, array.length - 1);

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


            //Pruebas desde tamaño 10 hasta 10000
        /*for (int i = 10; i <= 10000;i *= 10) {
            arrPru = new int[i];
            for (int j = 0; j < arrPru.length; j++) {
                arrPru[j] = rand.nextInt(i);
            }
            startTime = System.currentTimeMillis();
            mergeSort.sort(arrPru,0, arrPru.length - 1);
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
            mergeSort.sort(arrPru,0, arrPru.length - 1);
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
        mergeSort.sort(arrPru, 0, arrPru.length - 1);
        endTime = System.currentTimeMillis();
        tiempo = endTime - startTime;
        System.out.print("Matriz post insertion: "+arrPru.length+" ");
        System.out.println(Arrays.toString(arrPru));
        System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");*/

        }
    }
}
