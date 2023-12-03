package Punto2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Moda {
    /**
     * Encontrar la moda
     * @param matriz Elementos de la matriz
     * @return Retorna el elemento con mayor frencuencia de un subarreglo
     */
    public int encontrarModa(int[] matriz) {
        // Función auxiliar para contar la frecuencia de cada elemento en una matriz
        HashMap<Integer, Integer> contarFrecuencia = new HashMap<>();
        for (int elemento : matriz) {
            contarFrecuencia.put(elemento, contarFrecuencia.getOrDefault(elemento, 0) + 1);
        }

        // Encontrar la moda
        int moda = matriz[0];
        int frecuenciaMaxima = 0;

        //Se comparan todas la frecuencias de los elementos de la matriz
        for (int elemento : contarFrecuencia.keySet()) {
            int frecuencia = contarFrecuencia.get(elemento);
            if (frecuencia > frecuenciaMaxima) {
                moda = elemento;
                frecuenciaMaxima = frecuencia;
            }
        }
        return moda;
    }


    /**
     * Método divide y venceras para encontrar la moda
     * @param matriz Matriz que será dividida
     * @return retorna el elemento con mayor frecuencia de toda la matriz
     */

    public int modaDivideYVenceras(int[] matriz) {
        // Caso base: Si la matriz tiene un solo elemento, ese es la moda
        if (matriz.length == 1) {
            return matriz[0];
        }

        // Dividir la matriz en dos partes
        int mitad = matriz.length / 2;
        int[] izquierda = new int[mitad];
        int[] derecha = new int[matriz.length - mitad];
        System.arraycopy(matriz, 0, izquierda, 0, mitad);
        System.arraycopy(matriz, mitad, derecha, 0, matriz.length - mitad);

        // Recursividad de las mitades
        int modaIzquierda = modaDivideYVenceras(izquierda);
        int modaDerecha = modaDivideYVenceras(derecha);

        // Combinar los resultados y encontrar la moda global
        int[] combinado = new int[izquierda.length + derecha.length];
        System.arraycopy(izquierda, 0, combinado, 0, izquierda.length);
        System.arraycopy(derecha, 0, combinado, izquierda.length, derecha.length);

        int modaGlobal = encontrarModa(combinado);

        //Comparación entre frecuencias halladas en subarreglos para devolver el elemento mayor
        if(encontrarFrecuencia(matriz, modaGlobal) >= encontrarFrecuencia(matriz, modaIzquierda)){
            return modaGlobal;
        }
        else{
            return modaIzquierda;
        }
    }

    /**
     * Encontrar la frecuencia de un elemento en una matriz
     * @param matriz Matriz que será analizada
     * @param elemento Elemento que se desea analizar
     * @return Retorna la frecuencia del elemento en la matriz
     */

    public int encontrarFrecuencia(int[] matriz, int elemento) {
        int frecuencia = 0;
        for (int e : matriz) {
            if (e == elemento) {
                frecuencia++;
            }
        }
        return frecuencia;
    }


    public String devolverDatos(int[] elemento, int frecuencia){
        return "El elemento "+elemento[0]+" se repite "+frecuencia+" veces";
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Moda prueba = new Moda();

        int [] arrPru;

        for (int i = 10; i <= 10000;i *= 10) {
            arrPru = new int[i];
            for (int j = 0; j < arrPru.length; j++) {
                arrPru[j] = rand.nextInt(i);
            }
            Long startTime = System.currentTimeMillis();
            int resultado = prueba.modaDivideYVenceras(arrPru);
            Long endTime = System.currentTimeMillis();
            Long tiempo = endTime - startTime;
            System.out.println("La moda de la matriz de tamaño "+arrPru.length+" es: " + resultado);
            System.out.println(Arrays.toString(arrPru));
            System.out.println("El tiempo de ejecución es: " + tiempo + " milisegundos");
        }
    }
}
