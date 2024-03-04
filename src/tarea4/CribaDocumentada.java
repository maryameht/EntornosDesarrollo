package tarea4;

import java.util.Scanner;

/**
 * Clase CribaRefactorizada
 * Consiste en la refactorización del progrmama Criba
 * La funcionalidad de la clase es generar todos los los números primos de 1 hasta un número máximo especificado por el usuario
 * @author Maryam
 */
public class CribaDocumentada {

    /**
     * inicializamos los atributos i , j
     */

    private int i;
    private int j;

    /**
     * Creamos el constructor de la clase CribaRefactorizada
     * @param i valor entero que corresponde a un número cualquiera dentro del tamaño del array
     * @param j valor entero que corresponde al valor de multiplicado por 2
     */

    public CribaDocumentada(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Función que genera los números primos
     * siempre y cuando el parámetro max sea mayor o igual a 2
     * A su vez, esta función contiene otras subfunciones
     * @param max valor que correponde al número introducido por el usuario
     * @return
     *          el vector de números primos, si el max es mayor o igual a 2
     *          el vector vacío,  si el max es menor a 2
     */
    public static int[] generarPrimos (int max)
    {
        if (max >= 2) {
            /**
             * Aquí se realizan la declaración del tamaño del array
             * y del boolean esPrimo
             */
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

    /**
     * Función que inicializa el array y comprueba los números que son primos (true)
     * @param tamanyoArray valor del número introducido por el usuario más 1
     * @param esPrimo valor true (es primo)
     */

    private static void inicializarArray(int tamanyoArray, boolean[] esPrimo) {
        int i;
        for (i=0; i< tamanyoArray; i++)
            esPrimo[i] = true;
    }

    /**
     * Función que detecta los 0 y 1 como no primos (false)
     * @param esPrimo valor false (no primo) si el valor iésimo es 0 y 1
     */

    private static void elimina0y1QueNoSonPrimos(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    /**
     * Función que, dado un vector de enteros iniciado en 2,
     * se tachan todos los múltiplos de 2
     * @param tamanyoArray valor del número introducido por el usuario más 1
     * @param esPrimo valor true (es primo) o false (no es primo)
     */

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

    /**
     * Subfunción del método criba
     * Se encarga de eliminar el siguiente entero no tachado,
     * con el fin de conseguir tachar todos sus múltiplos
     * @param tamanyoArray valor del número introducido por el usuario más 1
     * @param esPrimo valor false (no primo)
     * @param i valor entero que corresponde a un número cualquiera dentro del tamaño del array
     */
    private static void eliminarMultiplosDei(int tamanyoArray, boolean[] esPrimo, int i) {
        int j;
        for (j=2* i; j< tamanyoArray; j+= i)
            esPrimo[j] = false;
    }

    /**
     * Función que cuenta cuántos números primos hay
     * @param tamanyoArray valor del número introducido por el usuario más 1
     * @param esPrimo valor true (es primo) o false (no es primo)
     * @return la cantidad de números primos
     */

    private static int cuantosPrimos(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /**
     * Función que rellena el vector con los números primos hallados
     * @param cuenta valor de la cantidad de números primos hallados
     * @param tamanyoArray valor del número introducido por el usuario más 1
     * @param esPrimo valor true (es primo) o false (no es primo)
     * @return los números primos
     */
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

