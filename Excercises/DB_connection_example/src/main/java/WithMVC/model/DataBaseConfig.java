/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WithMVC.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConfig {

    private Connection con;
    private String url, User, Password;
    private Statement st;

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return User;
    }

    public String getPassword() {
        return Password;
    }
    
    public Statement getStatement(){
        return st;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    

    public DataBaseConfig() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market",
                "Leon",
                "yoProg");
        
        st = con.createStatement();
    }
    
    public PreparedStatement preparedStatement(String sql) throws SQLException{
        return con.prepareStatement(sql);
    }
    
    public void closeConnection () throws SQLException{
        con.close();
    }
}
