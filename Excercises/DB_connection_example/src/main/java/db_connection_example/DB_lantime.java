/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_connection_example;
import db_connection_example.querys.Queries_LANTIMES;
import java.sql.*;

public class DB_lantime {

    public static void main(String[] args) {
        Queries_LANTIMES consultas = new Queries_LANTIMES();
        try {
            //1
           //Class.forName("com.mysql.jdbc.Driver"); 
           //2
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lantimes", "Leon", "yoProgramo");
           //3
           Statement st = con.createStatement();
           //4
           ResultSet rs = st.executeQuery(consultas.Simplequery1);

           while(rs.next()){
               System.out.println(rs.getString(1) + " " + rs.getString(2));
           }
           
           //5
           con.close();          
           
           
        } catch (Exception e) {
            System.out.println("no se ha podido conectar con la db");
        }
        
        
        
    }
    
}
