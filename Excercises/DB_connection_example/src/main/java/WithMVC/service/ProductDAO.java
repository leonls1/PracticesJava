/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package WithMVC.service;

import WithMVC.model.Product;
import WithMVC.model.ProductDTO;
import java.util.List;

/**
 *
 * @author leon
 */
public interface ProductDAO {
    public List<Product> getAllProducts();
    
    public Product getProductById(Long id);
    
    public void deleteProduct(Long id);
    
    public void updateProduct(Product product, Long id);
    
    public void saveProduct(ProductDTO productDTO);
}
