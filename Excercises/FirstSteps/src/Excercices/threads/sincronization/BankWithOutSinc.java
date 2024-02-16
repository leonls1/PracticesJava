package Excercices.threads.sincronization;

public class BankWithOutSinc {

}

class Bank {

    public Bank() {
        accounts = new double[100];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = 2000;
        }
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double monto) {
        if (accounts[cuentaDestino] < monto) {
            return;
        }
        System.out.println(Thread.currentThread());

        accounts[cuentaOrigen] -= monto; //le resta el monto de la transferencia a la cuenta de origen
        accounts[cuentaDestino] += monto;
        System.out.println("movimento completado \n");
        System.out.println("saldo total: " + getSaldoTotal());
        

    }

    public double getSaldoTotal() {
        double total = 0;
        for (int i = 0; i < accounts.length; i++) {
            total += accounts[i];
        }

        return total;

    }

    private final double[] accounts;
}

class EjecucionTransferencias implements Runnable{

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}