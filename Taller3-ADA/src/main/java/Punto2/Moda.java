package Punto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Moda {


    // Implementación de QuickSort en Java
    public static int[] quicksort(int[] arr) {
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

            int[] sortedLeft = quicksort(listToArray(left));
            int[] sortedRight = quicksort(listToArray(right));

            return concatenateArrays(sortedLeft, listToArray(middle), sortedRight);
        }
    }

    // Encontrar la moda de un vector en Java
    public static String encontrarModa(int[] arr) {
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

        return modaToString(moda) + " con frecuencia " + maxFrecuencia;
    }

    // Función para generar un arreglo aleatorio de tamaño n
    public static int[] generarArreglo(int n) {
        Random random = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(101); // Números aleatorios entre 0 y 100
        }

        return arr;
    }

    // Función para convertir una lista de enteros a un arreglo
    public static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    // Función para concatenar tres arreglos en uno solo
    public static int[] concatenateArrays(int[] arr1, int[] arr2, int[] arr3) {
        int[] result = new int[arr1.length + arr2.length + arr3.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        System.arraycopy(arr3, 0, result, arr1.length + arr2.length, arr3.length);
        return result;
    }

    // Función para convertir una lista de enteros a una cadena
    public static String modaToString(List<Integer> moda) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < moda.size(); i++) {
            sb.append(moda.get(i));
            if (i < moda.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Función para convertir un arreglo de enteros a una cadena
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Generar un vector aleatorio de tamaño n y encontrar su moda
    public static void generarYEncontrarModa() {
        for (int n : new int[]{10, 100, 1000, 2000}) {
            int[] arr = generarArreglo(n);
            System.out.println("Vector de tamaño " + n + " --> " + arrayToString(arr));
            System.out.println("La moda es: " + encontrarModa(arr));
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        int[] vector1 = {1, 2, 2, 3, 4};
        int[] vector2 = {1, 2, 2, 3, 3, 5};

        System.out.println("Vector de tamaño " + vector1.length + " --> " + arrayToString(vector1));
        System.out.println("La moda es: " + encontrarModa(vector1));

        System.out.println("Vector de tamaño " + vector2.length + " --> " + arrayToString(vector2));
        System.out.println("La moda es: " + encontrarModa(vector2));

        generarYEncontrarModa();
    }
}
