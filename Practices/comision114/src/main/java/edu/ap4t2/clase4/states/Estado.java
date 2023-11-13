package edu.ap4t2.clase4.states;

import edu.ap4t2.clase4.context.Context;
import edu.ap4t2.clase4.context.Mesa;

public interface Estado {

  public void reservar(Context m);

  public void liberar(Context m);

  public void ocupar(Context m);

}
