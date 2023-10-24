/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;

import java.io.IOException;
import java.nio.file.*;




public class FilesHandling {
    public static void main(String[] args) {
        String rutaArch1 = "C:\\Users\\leonl\\Documents\\NetBeansProjects\\FirstSteps\\src\\firststeps\\Tests\\Archivitos\\arch1.txt";
        
        try {
            escribirSecuenciaArchivo(rutaArch1, 5);
            mostrarArchivo(rutaArch1);
        } catch (Exception e) {
            
            System.out.println("No se ha podido encontrar el archivo");
        }
        System.out.println("hola que tal?".toUpperCase().replace(

"hola","chau"));
        
    }
    
    public static void mostrarArchivo(String ruta) throws IOException{
        for(String lineas : Files.readAllLines(Paths.get(ruta ))){
            System.out.println(lineas );
        }
    }
    
    public static void escribirSecuenciaArchivo(String ruta, int numeros) throws IOException{
        for (int i = 0; i <= numeros; i++) {
            //if i dont add the standarOpenOption.APPED the last line i Add with delete all the content before
            Files.writeString(Paths.get(ruta), i*i + "\n", StandardOpenOption.APPEND );
        }
    }
}
