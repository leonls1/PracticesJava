package edu.ap4t2.clase4.context;

import edu.ap4t2.clase4.states.Estado;

public interface Context {

  public void setState(Estado state);

}
