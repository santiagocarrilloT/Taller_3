package Punto3;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    /*Function to sort array using insertion sort*/
    void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        /*long startTime;
        long endTime;
        long tiempo;*/

        Random rand = new Random();
        InsertionSort inserSort = new InsertionSort();

        //int [] arrPru;
        int[] tamanosEntrada = {10, 50, 100, 500, 1000, 2000, 5000, 10000};
        int numEjecuciones = 3;

        while(numEjecuciones > 0){
            System.out.println("Ejecución Numero: " + (4 - numEjecuciones) + "\n");
            numEjecuciones--;
            for (int tamano : tamanosEntrada){
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
                inserSort.sort(array);

                // Medir el tiempo transcurrido
                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;

                // Imprimir array ordenado
                System.out.println("Array tamaño "+ tamano + " ordenado " +"\n"+ Arrays.toString(array));

                // Imprimir el tiempo transcurrido en segundos
                double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;

                // Imprime el tiempo de ejecución en segundos sin notación científica
                System.out.printf("Tiempo de ejecución: %.9f segundos", elapsedTimeInSeconds);
                System.out.println("\n");


            }

        }
        //Pruebas desde tamaño 10 hasta 10000
        /*for (int i = 10; i <= 10000;i *= 10) {
            arrPru = new int[i];
            for (int j = 0; j < arrPru.length; j++) {
                arrPru[j] = rand.nextInt(i);
            }
            startTime = System.currentTimeMillis();
            inserSort.sort(arrPru);
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
            inserSort.sort(arrPru);
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
        inserSort.sort(arrPru);
        endTime = System.currentTimeMillis();
        tiempo = endTime - startTime;
        System.out.print("Matriz post insertion: "+arrPru.length+" ");
        System.out.println(Arrays.toString(arrPru));
        System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");*/
    }
}
