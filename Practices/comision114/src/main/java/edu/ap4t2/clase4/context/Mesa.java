package edu.ap4t2.clase4.context;

import edu.ap4t2.clase4.states.Estado;

public class Mesa implements Context {

  private int id;
  private String mozo;

  private Estado state;

  public Mesa(Estado state) {
    this.state = state;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMozo() {
    return mozo;
  }

  public void setMozo(String mozo) {
    this.mozo = mozo;
  }

  public Estado getState() {
    return state;
  }

  public void setState(Estado state) {
    this.state = state;
  }

  public void reservar() {
    this.state.reservar(this);
  }

  public void liberar() {
    this.state.liberar(this);
  }

  public void ocupar() {
    this.state.ocupar(this);

  }

}
