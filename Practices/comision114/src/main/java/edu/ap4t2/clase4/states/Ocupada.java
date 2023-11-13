package edu.ap4t2.clase4.states;

import edu.ap4t2.clase4.context.Context;
import edu.ap4t2.clase4.context.Mesa;

public class Ocupada implements Estado {

  @Override
  public void liberar(Context m) {
    System.out.println("Se libera la mesa");
    m.setState(new Liberada());

  }

  @Override
  public void ocupar(Context m) {
    System.out.println("No es posible ocupar una mesa ya ocupada");
  }

  @Override
  public void reservar(Context m) {
    System.out.println("No es posible reservar una mesa ya ocupada");

  }

}
