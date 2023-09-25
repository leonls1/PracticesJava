/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excercises.interview_excercises;

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

    public int solvingPuzzle(int total_intances) {
        int sum = 0;
        int[] vars = {1, 1, 1, 1};

        for (int i = 0; i < total_intances; i++) {
            sum = 3 * vars[3] + vars[2] + 4 * vars[1] + vars[0];
            vars[0] = vars[1];
            vars[1] = vars[2];
            vars[2] = vars[3];
            vars[3] = sum;

        }
        return ((int)(sum%10000000000L));
    }
}
