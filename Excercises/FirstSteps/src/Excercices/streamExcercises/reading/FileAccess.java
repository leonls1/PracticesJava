package Excercices.streamExcercises.reading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.BufferedReader;

public class FileAccess {

    public static void main(String[] args) {
        readFile reader = new readFile();
        reader.read();
        
        writeFile writer = new writeFile();
        writer.write();
    }

}

class readFile {

    public void read() {
        FileReader entry = null;
        try {
            entry = new FileReader("C:\\Users\\leonl\\Documents\\NetBeansProjects\\Excercises\\example.txt");
            System.out.println("Archivo encontrado");
            
            BufferedReader buffer = new BufferedReader(entry);
            String line = "";
            
            /*
            int character = entry.read();
            while (character != -1) {
                char letter = (char) character;

                character = entry.read();
                System.out.print(letter);
            }*/
            
            while (line != null) { 
                line = buffer.readLine();   
                System.out.println(line);
            }
            System.out.println("\n" + "End of the file");
            entry.close();

        } catch (FileNotFoundException ex) {
            System.out.println("no se ha encontrado el archivo");
            Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException exception) {

        }
    }
}

class writeFile{
    
    public void write(){
        String toWrite = "alguna cosita para escribi en el archivo";
        
        try {
            FileWriter escritura = new FileWriter("C:\\Users\\leonl\\Documents\\NetBeansProjects\\Excercises\\write_example.txt",true);
            //FileWriter escritura2 = new FileWriter;
            
            escritura.write(toWrite);
            escritura.close();
            
        } catch (IOException ex) {
            Logger.getLogger(writeFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
