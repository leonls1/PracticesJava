package edu.ap4t2.clase4.templateMethod;

public class Cliente extends Persona {

  private int nroCliente;

  public Cliente(int nroCliente) {
    this.nroCliente = nroCliente;
  }

  @Override
  public String getIdentificador() {
    return Integer.toString(nroCliente);
  }

  @Override
  public String getTipoId() {
    return "número de cliente";
  }

}
