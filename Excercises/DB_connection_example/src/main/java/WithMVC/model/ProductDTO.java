/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WithMVC.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductDTO {

    private String name;
    private double price;
    private int productType, maxStock, actualStock;

    public ProductDTO() {
    }

    public ProductDTO(String name, double price, int productType, int maxStock, int actualStock) {
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.maxStock = maxStock;
        this.actualStock = actualStock;
    }
}
