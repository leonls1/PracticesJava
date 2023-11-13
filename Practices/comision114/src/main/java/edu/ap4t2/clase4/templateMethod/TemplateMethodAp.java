package edu.ap4t2.clase4.templateMethod;

public class TemplateMethodAp {

  public static void main(String[] args) {

    Cliente c1 = new Cliente(4465464);

    Empleado e1 = new Empleado("AB4589213");

    c1.identificate();
    e1.identificate();
    
  }
}
