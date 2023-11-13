package edu.ap4t2.model;

public interface Interfaz {

  public void imprimir();

  default void otroMetodo() {
    System.out.println("Método por defecto");
  }

  public static void metodoEstatico() {
    System.out.println("Método por defecto");
  }
}
