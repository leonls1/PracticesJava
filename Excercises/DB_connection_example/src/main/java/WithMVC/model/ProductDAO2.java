/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WithMVC.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leon
 */
public class ProductDAO2 {

    //data access object for the product entity
    public ResultSet getAllProducts() {
        try {
            rs = conection.getStatement().executeQuery("SELECT * FROM PRODUCT");
        } catch (SQLException e) {

        } finally {
            return rs;
        }
    }

    public ResultSet getById(int id) throws SQLException {
        preparedStatement = conection.preparedStatement(GetProductById);

        preparedStatement.setInt(1, id);

        try {
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet rs;
    private DataBaseConfig conection;
    private final String GetProductById = "SELECT * FROM PRODUCT WHERE id = ?";
    private PreparedStatement preparedStatement;
}
