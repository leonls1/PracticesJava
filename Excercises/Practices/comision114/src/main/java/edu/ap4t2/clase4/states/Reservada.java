package edu.ap4t2.clase4.states;

import edu.ap4t2.clase4.context.Context;
import edu.ap4t2.clase4.context.Mesa;

public class Reservada implements Estado {

  @Override
  public void liberar(Context m) {
    System.out.println("No es posible liberar una mesa reservada");

  }

  @Override
  public void ocupar(Context m) {
    System.out.println("Llegaron los comensales");
    m.setState(new Ocupada());

  }

  @Override
  public void reservar(Context m) {
    System.out.println("No es posible reservar una mesa ya reservada");

  }

}
