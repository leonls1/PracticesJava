/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package db_connection_example;
import java.sql.*;
public class DB_connection_example {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello World!");
        
        /*1)*/Class.forName("com.mysql.jdbc.Driver");
        /*2)*/Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market","Leon", "yoProgramo");
        /*3)*/Statement st =  con.createStatement();
        
        String creatingProductsTable = "CREATE TABLE IF NOT EXISTS super_market.product("
                + " id INTEGER,"
                + " name varchar(20) NOT NULL, "
                + " price DOUBLE NOT NULL,"
                + " max_stock INT,"
                + " actual_stock INT,"
                    + "CONSTRAINT product_id_pk PRIMARY KEY(id),"
                    + "CONSTRAINT product_name_un UNIQUE(name)) ";
                
        String loadingANewPRoduct = "INSERT INTO product(id, name,price, actual_stock, max_stock)"
                + "VALUES(2,'alfajorcito_chiquito', 100, 50, 200 )";
        
        /*4)*/int result = st.executeUpdate(creatingProductsTable);
        int rs = st.executeUpdate(loadingANewPRoduct);
        System.out.println(result);
        System.out.println(rs);
        
        
        /*5)*/con.close();
    }
    
    
}
