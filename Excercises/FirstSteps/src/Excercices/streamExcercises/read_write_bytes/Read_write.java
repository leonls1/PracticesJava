package Excercices.streamExcercises.read_write_bytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Read_write {

    public static void main(String[] args) {
        
        write_bytes.writeFile(read_bytes.readFile());
    }
}

class write_bytes {
    static void writeFile(int data[]){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\leonl\\Documents\\NetBeansProjects\\Excercises\\write_example_copy.txt");
            for (int i : data) {
                fileOutputStream.write(i);
            }
            
            fileOutputStream.close();
            
        } catch (Exception e) {
        }
    }
}

class read_bytes {

    static int[] readFile() {

        try {
            int count = 0;
            int[] values = new int[41];
            FileInputStream readFileInputStream = new FileInputStream("C:\\Users\\leonl\\Documents\\NetBeansProjects\\Excercises\\write_example.txt");
            int actualValue = 0;
            System.out.println("the file exists");

            while (actualValue != -1) {
                actualValue = readFileInputStream.read();
                if (actualValue != -1) {
                    values[count] = actualValue;
                    count++;
                }
            }

            readFileInputStream.close();
            return values;
        } catch (Exception e) {
            System.out.println("the file doesn't exists");
            e.printStackTrace();
        }
        return null;
    }
}
