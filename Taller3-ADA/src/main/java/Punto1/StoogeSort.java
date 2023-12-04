/**
@Author: Edwardo Calderon, Santiago Carrillo, Edwar Forero
@version: 1.0
 */
package Punto1;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase StoogeSort para ordenamiento de datos
 */
public class StoogeSort {
    /**
     * Metodo StoogeSort para ordanamiento de datos
     * @param matriz corresponde al arreglo que será ordenado
     * @param i La posición inicial del arreglo (fracción izquierda)
     * @param j La posición final del arreglo (fracción derecha)
     */
    public void stoogesort(int matriz[], int i, int j)
    {
        //Si la posición inicial es mayor o igual a la posición final, significa que el arreglo no se puede dividir
        if (i >= j)
            return;

        //Si la fracción izquierda es mayor que la fracción derecha, se intercambian
        if (matriz[i] > matriz[j]) {
            int t = matriz[i];
            matriz[i] = matriz[j];
            matriz[j] = t;
        }

        //Si el array tiene más de 2 elementos se divide en 3 partes para iniciar el ordenamiento
        if (j-i+1 > 2) {
            int t = (j-i+1) / 3;
            stoogesort(matriz, i, j-t);
            stoogesort(matriz, i+t, j);
            stoogesort(matriz, i, j-t);
        }
    }
    /**
     * Metodo main para probar el ordenamiento
     * @param args imprime el tiempo de ejecución en milisegundos y la matriz ordenada
     */
    public static void main(String args[]) {
        StoogeSort stg = new StoogeSort();
        Random rand = new Random();

        int arrPru[];

        for (int valor = 10; valor <= 10000; valor *= 10) {
            arrPru = new int[valor];
            for (int i = 0; i < arrPru.length; i++) {
                arrPru[i] = rand.nextInt(valor);
            }
            long startTime = System.currentTimeMillis();
            stg.stoogesort(arrPru, 0, arrPru.length-1);

            long endTime = System.currentTimeMillis();
            long tiempoEjecucion = endTime - startTime;
            System.out.println("->Tamaño matriz: "+ valor+"<-");
            System.out.println(Arrays.toString(arrPru));
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempoEjecucion);
        }
    }
}
