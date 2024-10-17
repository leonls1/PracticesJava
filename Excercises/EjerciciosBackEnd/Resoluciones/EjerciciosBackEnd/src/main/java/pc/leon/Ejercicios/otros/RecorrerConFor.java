package pc.leon.Ejercicios.otros;

public class RecorrerConFor {
    /*
    El objetivo es lograr imprimir por pantalla las siguientes figuras pero solo
    pudiendo imprimir a la vez uno y solo un asterisco o uno y solo un espacio,
    es decir solo podemos imprimir una variable de tipo char que tenga como valor '*' o ' '.
    Figura 1
* * * * * *
* * * * * *
* * * * * *
* * * * * *
Figura 3
*
* *
* * *
* * * *
* * * * *
Figura 2
* * * * * *
 * * * * * *
* * * * * *
 * * * * * *
Figura 4
*
* *
* * *
* * * *
* * * * *
* * * *
* * *
* *
*
*/

    public static void figura1(){
        for(int i = 0; i <4 ; i++){
            int contador = 0;
            while(contador<6){
                System.out.print('*');
                System.out.print(' ');
                contador++;
            }
            System.out.println();
        }

    }
    public static void figura2(){

        for (int i = 1; i < 6; i++){
            int contador = 0;
            while(contador< i){
                System.out.print('*');
                System.out.print(' ');
                contador++;
            }
            System.out.println();
        }
    }
    public static void figura3(){

            for(int i = 0; i <4 ; i++){
                int contador = 0;
                while(contador<6){
                    System.out.print('*');
                    System.out.print(' ');
                    contador++;
                }
                if(i ==1 || i==3){
                    System.out.print(' ');
                }
                System.out.println();

            }
    }
    public static void figura4(){
        figura2();
        for (int i = 6; i > 0; i--){
            int contador = 0;
            while(contador< i){
                System.out.print('*');
                System.out.print(' ');
                contador++;
            }
            System.out.println();
        }

    }
}
