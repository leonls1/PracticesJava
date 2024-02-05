package Excercices.threads;

public class EjemploRunnable extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ejecutando el hilo: " + this.getName());
            
        }
    }
    

}
