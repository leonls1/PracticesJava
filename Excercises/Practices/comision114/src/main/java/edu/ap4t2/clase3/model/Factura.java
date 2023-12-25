package edu.ap4t2.clase3.model;

public class Factura {

  private Integer id;
  private String concepto;
  private Double monto;
  private TipoCompra tipoCompra;

  private Cliente cliente;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getConcepto() {
    return concepto;
  }

  public void setConcepto(String concepto) {
    this.concepto = concepto;
  }

  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public TipoCompra getTipoCompra() {
    return tipoCompra;
  }

  public void setTipoCompra(TipoCompra tipoCompra) {
    this.tipoCompra = tipoCompra;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((concepto == null) ? 0 : concepto.hashCode());
    result = prime * result + ((monto == null) ? 0 : monto.hashCode());
    result = prime * result + ((tipoCompra == null) ? 0 : tipoCompra.hashCode());
    result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Factura other = (Factura) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (concepto == null) {
      if (other.concepto != null)
        return false;
    } else if (!concepto.equals(other.concepto))
      return false;
    if (monto == null) {
      if (other.monto != null)
        return false;
    } else if (!monto.equals(other.monto))
      return false;
    if (tipoCompra != other.tipoCompra)
      return false;
    if (cliente == null) {
      if (other.cliente != null)
        return false;
    } else if (!cliente.equals(other.cliente))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Factura [id=" + id + ", concepto=" + concepto + ", monto=" + monto + ", tipoCompra=" + tipoCompra
        + ", cliente=" + cliente + "]";
  }

}
