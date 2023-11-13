package edu.ap4t2.clase4.app;

import edu.ap4t2.clase4.context.Mesa;
import edu.ap4t2.clase4.states.Liberada;

public class StateApp {

  public static void main(String[] args) {
    Mesa m = new Mesa(new Liberada());

    m.reservar();
    m.liberar();
    m.reservar();
    m.ocupar();

    m.reservar();
    m.liberar();
    m.liberar();
  }

}
