/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excercises.Supermercado;

/**
 *
 * @author leon
 */
public class Producto {
    private int id = 0;
    
    private double price;

    private String name;

    private TipoProducto type;

    private int stock;

    public Producto(double price, String name, TipoProducto type, int stock) throws PrecioInvalido {
         if(0 == id){
             id =1; }
         else{             
         id++;
         } 
        if (price >= 0) {
            this.price = price;
        } else {
            throw new PrecioInvalido();
        }
        this.name = name;
        this.type = type;
        this.stock = stock;
    }  

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public TipoProducto getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TipoProducto type) {
        this.type = type;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
