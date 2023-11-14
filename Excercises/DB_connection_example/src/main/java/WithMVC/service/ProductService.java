/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WithMVC.service;

import WithMVC.model.Product;
import WithMVC.model.ProductDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leon
 */
public class ProductService implements ProductDAO{
    
    private CallableStatement st;
    private Connection con;
    private ResultSet rs;
    
    
    

    public ProductService() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market",
                "Leon",
                "yoProg");
    }
    
    
    

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            st = con.prepareCall("{call get_all_products");
            rs = st.executeQuery();
            
            while (rs.next()) {                
                rs.getString("name");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        
        try {
            st = con.prepareCall("{call get_product_by_id(?)");
            st.setInt(1, 3);
            rs = st.executeQuery();
            
            while (rs.next()) {                
                System.out.println(rs.getString("name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  product;
    }

    @Override
    public void deleteProduct(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateProduct(Product product, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
