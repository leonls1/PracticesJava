package Excercices.threads;

import java.util.ArrayList;
import java.util.List;

public class TestingThreads {

    public static void main(String[] args) {

        List<Thread> hilos = new ArrayList<>();

        addTread(hilos);
        addTread(hilos);
        addTread(hilos);
        addTread(hilos);

        hilos.stream().forEach(t -> {
            System.out.println("Estado del hilo: " + !t.isInterrupted());
            System.out.println("interrumpuendo el hilo");
            t.interrupt();
            
            System.out.println("Estado del hilo: " + !t.isInterrupted() + "\n");
            
        });
    }

    //instanciando hilos e iniciandolos
    private static void addTread(List<Thread> list) {
        Runnable runnable = new EjemploRunnable();
        Thread hilito = new Thread(runnable);
        hilito.start();
        list.add(hilito);
    }

}
