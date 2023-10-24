/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.exceptions;

/**
 *
 * @author leon
 */
public class Exceptions {

    public static void main(String[] args) {

        int[] vector = new int[3];
        int[] vectors = new int[4];

        Methods.cargandoVec(vector);
        Methods.cargandoVec(vectors);

    }

    class Methods {

        static void cargandoVec(int[] vector) throws ArrayIndexOutOfBoundsException {
            try {
                vector[0] = 3;
                vector[1] = 4;
                vector[2] = 1;
                vector[3] = 4;
                System.out.println("Cargado exitosamente");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No se puede cargar el vector en esa posicion");
            }

        }
    }

}
