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
        long startTime;
        long endTime;
        long tiempo;

        Random rand = new Random();
        InsertionSort inserSort = new InsertionSort();

        int [] arrPru;

        //Pruebas desde tamaño 10 hasta 10000
        for (int i = 10; i <= 10000;i *= 10) {
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
        System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");
    }
}
