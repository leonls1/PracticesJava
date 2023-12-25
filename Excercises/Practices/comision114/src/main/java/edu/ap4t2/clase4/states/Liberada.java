package edu.ap4t2.clase4.states;

import edu.ap4t2.clase4.context.Context;
import edu.ap4t2.clase4.context.Mesa;

public class Liberada implements Estado {

  @Override
  public void liberar(Context m) {
    System.out.println("No es posible liberar una mesa ya libre");

  }

  @Override
  public void ocupar(Context m) {
    System.out.println("Ocupo la mesa");
    m.setState(new Ocupada());
  }

  @Override
  public void reservar(Context m) {
    System.out.println("Reservo la mesa");
    m.setState(new Reservada());

  }

}
