package tarea4;

import java.util.Scanner;
public class CribaRefactorizada {

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int tamanyoArray = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[tamanyoArray];

            // Inicializar el array
            inicializarArray(tamanyoArray, esPrimo);

            // Eliminar el 0 y el 1, que no son primos
            elimina0y1QueNoSonPrimos(esPrimo);

            // Criba
            criba(tamanyoArray, esPrimo);
            // ¿Cuántos primos hay?
            int cuenta = cuantosPrimos(tamanyoArray, esPrimo);

            // Rellenar el vector de números primos
            return rellenarVectorConNumerosPrimos(cuenta, tamanyoArray, esPrimo);

        } else {
            // max < 2
            return new int[0];
        // Vector vacío
        }
    }

    private static int[] rellenarVectorConNumerosPrimos(int cuenta, int tamanyoArray, boolean[] esPrimo) {
        int i;
        int j;
        int[] primos = new int[cuenta];

        for (i=0, j=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int cuantosPrimos(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    private static void criba(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(tamanyoArray)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                eliminarMultiplosDei(tamanyoArray, esPrimo, i);
            }
        }
    }

    private static void eliminarMultiplosDei(int tamanyoArray, boolean[] esPrimo, int i) {
        int j;
        for (j=2* i; j< tamanyoArray; j+= i)
            esPrimo[j] = false;
    }

    private static void elimina0y1QueNoSonPrimos(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    private static void inicializarArray(int tamanyoArray, boolean[] esPrimo) {
        int i;
        for (i=0; i< tamanyoArray; i++)
            esPrimo[i] = true;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }

}
