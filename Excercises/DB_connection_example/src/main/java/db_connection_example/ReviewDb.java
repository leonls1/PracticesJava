/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_connection_example;

import java.sql.*;
public class ReviewDb {
      public static void main(String[] args) throws ClassNotFoundException, SQLException{
        //1    isn't necesary
        Class.forName("com.mysql.jdbc.Driver");
        
        //2
        
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market","Leon", "yoProgramo");
        
        //3
        Statement st = con.createStatement();
        
        String query1 = "Select * FROM product";
        //4
        ResultSet rs = st.executeQuery(query1);
        
        PreparedStatement preparedStatement = con.prepareStatement("Select * FROM ?");
        preparedStatement.setString(0, "tipoproducto");
        
            
        
        while(rs.next()){
            System.out.println("product id: "
                    + rs.getInt("id") );
        }
        
        preparedStatement.execute();
        
        //5
        con.close();       
        
        
        
    }
  


}
