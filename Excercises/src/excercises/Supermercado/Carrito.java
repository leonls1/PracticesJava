/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excercises.Supermercado;
import java.util.ArrayList;

/**
 *
 * @author leon
 */
public class Carrito {    
    
    private ArrayList<Producto> carrito, productosDiponibles;
    private Descuento discount;
    
    public Carrito() {
        carrito = new ArrayList<Producto>();
        crearProductosEstandar();
    }
    
    public void  mostrarProductos(){
        System.out.println("Productos Disponibles:");
        for(Producto prod :  productosDiponibles){
            System.out.println(prod.getId() + "_" + prod.getName() + "\n" + " precio: " + prod.getStock() + " Cantidad En stock: " +prod.getStock() + "\n");            
        }
        System.out.println("Ingrese el producto deseado");
        System.out.println("Ingrese la cantidad deseada");
    }
    
    
    public void crearProductosEstandar() throws PrecioInvalido{
        carrito = new ArrayList<Producto>();
        Producto leche = new Producto(100,"Leche", TipoProducto.SIN_TACC, 100);
        Producto agua = new Producto(100,"Agua", TipoProducto.BAJAS_CALORIAS, 100);
        Producto pan = new Producto(100,"Pan", TipoProducto.SIN_LACTOSA, 100);
        Producto sal = new Producto(100,"Sal de mesa", TipoProducto.SIN_TACC, 100);
        
        productosDiponibles.add(leche);
        productosDiponibles.add(agua);
        productosDiponibles.add(pan);
        productosDiponibles.add(sal);
    }  
    
    class item{
        Producto prod;
        int cantidad;
    }
    
}
