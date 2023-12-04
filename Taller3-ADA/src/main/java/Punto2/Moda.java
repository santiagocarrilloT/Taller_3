/**
 * @autor Edwar Forero, Santiago Carrillo, Edwardo Calderon
 */
package Punto2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Clase Moda para encontrar la moda de un vector
 */
public class Moda {

    /**
     * Método para ordenar un array utilizando QuickSort
     * @param arr array a ordenar
     * @return array ordenado
     */
    public int[] quicksort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        } else {
            int pivot = arr[arr.length / 2];
            List<Integer> left = new ArrayList<>();
            List<Integer> middle = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            for (int x : arr) {
                if (x < pivot) {
                    left.add(x);
                } else if (x == pivot) {
                    middle.add(x);
                } else {
                    right.add(x);
                }
            }

            int[] sortedLeft = quicksort(left.stream().mapToInt(Integer::intValue).toArray());
            int[] sortedRight = quicksort(right.stream().mapToInt(Integer::intValue).toArray());
            int[] sortedMiddle = middle.stream().mapToInt(Integer::intValue).toArray();

            return concatenateArrays(sortedLeft, sortedMiddle, sortedRight);
        }
    }

    /**
     * Método para encontrar la moda de un vector
     * @param arr vector a analizar
     * @return moda/s del vector y su/s frecuencia/s
     */
    public String encontrarModa(int[] arr) {
        // Ordenar el vector utilizando QuickSort
        int[] arrSorted = quicksort(arr);

        // Inicializar variables para la moda
        List<Integer> moda = new ArrayList<>();
        int maxFrecuencia = 1;
        int frecuenciaActual = 1;

        // Encontrar la moda recorriendo el vector ordenado
        for (int i = 1; i < arrSorted.length; i++) {
            if (arrSorted[i] == arrSorted[i - 1]) {
                frecuenciaActual++;
            } else {
                frecuenciaActual = 1;
            }

            if (frecuenciaActual > maxFrecuencia) {
                moda.clear();
                moda.add(arrSorted[i]);
                maxFrecuencia = frecuenciaActual;
            } else if (frecuenciaActual == maxFrecuencia) {
                moda.add(arrSorted[i]);
            }
        }
        return "Moda(s) "+ moda + ", Frecuencia: " + maxFrecuencia;
    }

    /**
     * Método para concatenar 3 arrays
     * @param arr1 primer array
     * @param arr2 segundo array
     * @param arr3 tercer array
     * @return array concatenado
     */
    public int[] concatenateArrays(int[] arr1, int[] arr2, int[] arr3) {
        int[] result = new int[arr1.length + arr2.length + arr3.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        System.arraycopy(arr3, 0, result, arr1.length + arr2.length, arr3.length);
        return result;
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
            System.out.println("\n"+"Ejecución Numero: " + (3 - numEjecuciones));
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

            // Ejecutar Moda
            encontrarModa(array);

            // Medir el tiempo transcurrido
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            // Imprimir array ordenado
            System.out.println("Array tamaño " + tamano + " ordenado: "+Arrays.toString(quicksort(array)));

            // Imprimir el tiempo transcurrido en segundos
            double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;

            // Imprime el tiempo de ejecución en segundos sin notación científica
            System.out.printf("Tiempo de ejecución: %.9f segundos", elapsedTimeInSeconds);
            System.out.println("\n");
        }
    }


    /**
     * Método main para probar la clase Moda
     * @param args Imprime el tiempo de ejecución en milisegundos, el vector y la moda del vector
     */
    public static void main(String[] args) {
        Moda md = new Moda();

        // Tamaños de entrada
        int[] tamanosEntrada = {10, 100, 1000, 10000};

        // Ejecutar el algoritmo para cada tamaño de entrada
        for (int tamano : tamanosEntrada) {
            md.ordenarYMostrarArray(tamano, 2);
        }
    }
}
