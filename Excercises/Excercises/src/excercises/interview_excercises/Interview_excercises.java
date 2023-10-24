/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excercises.interview_excercises;

import java.math.*;
import java.util.Random;

/**
 *
 * @author leon
 */
public class Interview_excercises {

    /* 
    función solucionarRompecabezas(N) {
.var_A = 1
.var_B = 1
.var_C = 1
.var_D = 1

.para i en el rango de 1 a N {
..resultado = 3 * var_D + 1 * var_C + 4 * var_B + 1 * var_A
..var_A = var_B
..var_B = var_C
..var_C = var_D
..var_D = resultado
.}

.devolver var_D % 10000000000 // últimos 10 dígitos de var_D
}
     */
    public long solvingPuzzle(long total_intances) {
        long sum = 0;
        long[] vars = {1, 1, 1, 1};

        for (int i = 0; i < total_intances; i++) {
            sum = 3 * vars[3] + vars[2] + 4 * vars[1] + vars[0];
            vars[0] = vars[1];
            vars[1] = vars[2];
            vars[2] = vars[3];
            vars[3] = sum;

        }
        return ((vars[3] % ((long) Math.pow(10, 10))));
    }

    /*
    Nos encontramos en busca de programadores para trabajar de manera remota, en horario de tiempo completo y en relación de dependencia. Para formar parte de nuestro proceso de selección, te proponemos resolver el siguiente reto.

Un joven estaba elaborando un generador automático de una versión ampliada y aleatoria de la canción para niños "Sal de ahí chivita". Te mostramos el pseudocódigo para que busques la siguiente respuesta:
Considerando que cada línea lleva 1 milisegundo en ejecutarse,
¿Cuál es el tiempo esperado de ejecución para N = 1, 10, 50 y 200? Tené en cuenta que los puntos son para indentación.

Pseudocódigo:
array animales = [“el lobo”, “el toro”, … ]; // 100 animales

map LlamarA = {}

print(“Sal de ahí chivita chivita, sal de ahí de ese lugar”)
actualmente = “la chiva”
Realizar N veces {
..prox = elemento_random(animales)
..LlamarA[actualmente] = prox
..print(“Hay que llamar a “ + prox + “ para que saque a “ + actualmente)
..actualmente = prox
..array remover = [ ]
..inspeccionar = “la chiva”
..repetir hasta que inspeccionar no esté en LlamarA {
....remover.insertar_primero(LlamarA[inspeccionar] + “ no quiere sacar a ” + inspeccionar)
....inspeccionar = LlamarA[inspeccionar]
..}
for i in remover {
....print(i)
..}
..print(“La chiva no quiere salir de ahí. Sal de ahí chivita chivita, sal de ahí de ese lugar”)
}


Ejemplo de output para N = 3

Sal de ahí chivita chivita, sal de ahí de ese lugar
Hay que llamar a el lobo para que saque a la chiva
el lobo no quiere sacar a la chiva
La chiva no quiere salir de ahí. Sal de ahí chivita chivita, sal de ahí de ese lugar
Hay que llamar a el perro para que saque a el lobo
el perro no quiere sacar a el lobo
el lobo no quiere sacar a la chiva
La chiva no quiere salir de ahí. Sal de ahí chivita chivita, sal de ahí de ese lugar
Hay que llamar a el leon para que saque a el perro
el leon no quiere sacar a el perro
el perro no quiere sacar a el lobo
el lobo no quiere sacar a la chiva
La chiva no quiere salir de ahí. Sal de ahí chivita chivita, sal de ahí de ese lugar
     */
 /*
    Te instamos a resolver un dilema. Es indispensable que aportes y expliques el procedimiento, así como el código
    (en caso de haberlo desarrollado), que utilizaste para descubrir la respuesta.

Considera a un muchacho que se deleita pintando su tablero de ajedrez. 
    Su objetivo es saturar cada celda con tonos rojos o azules. En busca de darle una identidad propia, 
    procura tener un equilibrio entre los espacios rojos y azules, previniendo que dos filas o 
    columnas contengan el mismo número de celdas rojas. ¿Lograría pintar el tablero de ajedrez 
    siguiendo estas pautas? ¿Qué acontecería si, en vez de un tablero de ajedrez común de 8x8, 
    tuviera uno monumental de 1000x1000?
     */
    public int[][] chessTable(int n) {
        int[][] table = new int[n+1][n];
        int[] redXcol = new int[n];
        int[] blueXcol = new int[n];

        for (int i = 0; i < n ; i++) {
            redXcol[i] = 0;
            blueXcol[i] = 0;
        }

        Random rand = new Random();
        int randColor, redXrow, blueXrow;

        for (int i = 0; i < n  ; i++) {
            redXrow = blueXrow = 0;

            for (int j = 0; j < table[i].length ; j++) {
                randColor = rand.nextInt(2); //0 = blue, 1 = red
                if (randColor == 0) {
                    if ((blueXrow < n/2) && (blueXcol[j] < n/2)) {
                       table[i][j] = 0;                       
                       blueXrow++;
                       blueXcol[j]++;
                        
                    } else {
                        table[i][j] = 1;
                        redXrow++;
                        redXcol[j]++;
                    }
                } else if ((redXrow < n/2) && (redXcol[j] < n/2)) {
                    table[i][j] = 1;
                        redXrow++;
                        redXcol[j]++;
                } else {
                    table[i][j] = 0;                       
                       blueXrow++;
                       blueXcol[j]++;
                }

            }
        }

        return table;
    }    
 
    private void paintCell(int nRow, int nCol, int colr, int count, int[] count2, int[][] table) {
        count++;
        count2[nCol]++;
        table[nRow][nCol] = colr;
    }

    public void printMatNxN(int[][] mat) {
        String chain = "";

        for (int i = 0; i < mat.length; i++) {
            System.out.println(chain);
            chain = "";
            for (int j = 0; j < mat[i].length; j++) {
                chain += mat[i][j] + " ";
            }
        }
    }

    /*
    Si estás interesado en unirte a nosotros, te alentamos a postularte a nuestra propuesta de empleo y enviarnos tu solución al siguiente problema de programación.

¿Podrías indicarnos cuál sería el output al ejecutar el siguiente pseudocódigo? 
    (suponiendo que el equipo dispone de los recursos necesarios para completar la tarea). 
    Recordá detallarnos tu línea de pensamiento y las etapas que seguiste para llegar a tu conclusión.

const M = 2023

funcion compute(n)
string s = ""
para i desde 1 hasta n
s = s + n
fin para
return convertir_a_numero(s) % M
fin funcion

para cada n en 1, 2, 5, 10, 20, 827785024886475841
imprimir(n + ": " + compute(n))
fin para
fin funcion

Resultado parcial de la ejecución
1: 1
2: 22
5: 934
10: 738
20: 1481
827785024886475841: ???

     */
    public int compute(long n) {
        final int M = 2023;
        String s = "";

        for (int i = 0; i < n; i++) {
            s += n;
        }
        return (int) (Long.parseLong(s) % M);
    }

    public void printComputed() {
        long[] vars = {1, 2, 5, 10, 20, 827785024886475841L};
        for (long x : vars) {
            System.out.println(compute(x));
        }

    }

    public int compute2(int n) {
        final int M = 2023;
        BigInteger result = BigInteger.ZERO;
        BigInteger nBigInt = BigInteger.valueOf(n);

        for (int i = 0; i < n; i++) {
            result = result.multiply(BigInteger.TEN).add(nBigInt);
        }

        return result.mod(BigInteger.valueOf(M)).intValue();
    }

    /*
    Una máquina arranca su tarea imprimiendo los números 2023, 2024 y 2025. Luego, 
    sin interrupción, sigue imprimiendo la suma de los últimos tres números que ha impreso: 
    6072, 10121, 18218, y así sucesivamente. ¿Serías capaz de determinar cuáles son los cuatro 
    dígitos finales del número impreso en la posición 2023202320232023? Como referencia, 
    en la posición 50, el número impreso es 8188013234823360, que finaliza en 3360.
     */
    public int threeSum(long n) {
        long[] arr = {2023, 2024, 2025};
        long sum;
        for (int i = 0; i < n; i++) {
            sum = arr[0] + arr[1] + arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = sum;
        }

        return (int) (arr[2] % 10000);

    }

}
