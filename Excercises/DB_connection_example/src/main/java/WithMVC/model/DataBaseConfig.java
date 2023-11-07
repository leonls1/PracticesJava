/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WithMVC.model;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leon
 */
public class DataBaseConfig {
    private Connection  con;
    private String url, User, Password;

    public Connection getCon() {
        return con;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return User;
    }

    public String getPassword() {
        return Password;
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
    
    
    

    public DataBaseConfig() throws SQLException{
         con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/super_market",
                        "Leon",
                        "yoProg");
    }
}
