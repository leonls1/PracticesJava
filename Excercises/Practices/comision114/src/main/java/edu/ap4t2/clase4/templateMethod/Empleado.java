package edu.ap4t2.clase4.templateMethod;

public class Empleado extends Persona {

  String nroLegajo;

  public Empleado(String nroLegajo) {
    this.nroLegajo = nroLegajo;
  }

  @Override
  public String getIdentificador() {
    return nroLegajo;
  }

  @Override
  public String getTipoId() {
    return "número de legajo";
  }

}
