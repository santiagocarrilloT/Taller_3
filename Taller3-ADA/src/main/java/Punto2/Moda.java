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
    public static int[] concatenateArrays(int[] arr1, int[] arr2, int[] arr3) {
        int[] result = new int[arr1.length + arr2.length + arr3.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        System.arraycopy(arr3, 0, result, arr1.length + arr2.length, arr3.length);
        return result;
    }

    /**
     * Método main para probar la clase Moda
     * @param args Imprime el tiempo de ejecución en milisegundos, el vector y la moda del vector
     */
    public static void main(String[] args) {
        Moda moda = new Moda();
        Random rand = new Random();

        int arrPru[];

        for (int valor = 10; valor <= 10000; valor *= 10) {
            arrPru = new int[valor];
            for (int i = 0; i < arrPru.length; i++) {
                arrPru[i] = rand.nextInt(valor);
            }
            System.out.println("->Tamaño matriz: "+ valor+"<-");
            System.out.println(Arrays.toString(arrPru));
            long startTime = System.currentTimeMillis();
            System.out.println(moda.encontrarModa(arrPru));
            long endTime = System.currentTimeMillis();
            long tiempoEjecucion = endTime - startTime;

            System.out.println("Tiempo de ejecución en milisegundos: " + tiempoEjecucion + "\n");
        }
    }
}
