package edu.ap4t2.clase4.templateMethod;

import java.lang.StringBuilder;

public abstract class Persona {

  private String nombre;
  private String DNI;

  public void identificate() {
    // template method
    StringBuilder sb = new StringBuilder("Hola, me identifico con: ");
    sb.append(getTipoId());
    sb.append(". El nro. es: ");
    sb.append(getIdentificador());
    System.out.println(sb.toString());

  }

  public abstract String getTipoId();

  public abstract String getIdentificador();

}
