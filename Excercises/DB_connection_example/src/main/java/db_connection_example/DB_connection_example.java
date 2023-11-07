/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package db_connection_example;

import db_connection_example.querys.Queries_LANTIMES;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DB_connection_example {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Queries_LANTIMES consultas = new Queries_LANTIMES();

        //1
        Class.forName("com.mysql.jdbc.Driver");
        //2
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market", "Leon", "yoProgramo");
        //3
        Statement st = con.createStatement();

        String creatingProductsTable = "CREATE TABLE IF NOT EXISTS super_market.product("
                + " id INTEGER,"
                + " name varchar(20) NOT NULL, "
                + " price DOUBLE NOT NULL,"
                + " max_stock INT,"
                + " actual_stock INT,"
                + "CONSTRAINT product_id_pk PRIMARY KEY(id),"
                + "CONSTRAINT product_name_un UNIQUE(name)) ";

        String loadingANewPRoduct = "INSERT INTO product(id, name, price, actual_stock, max_stock)"
                + "VALUES(2,'alfajorcito_chiquito', 100, 50, 200 )";

        PreparedStatement consultaPreparada = con.prepareStatement("DELETE FROM product WHERE id = ?");

        consultaPreparada.setInt(1, 2);
        /*
        //4
        consultaPreparada.execute();
         */
        //5

        String traerTipoProducto = "SELECT tp.descrip FROM tipoProducto tp";
        ArrayList<String> tiposProudcttos = new ArrayList<>();
        //tiposProudcttos.add("SELECCIONE EL PRODUCTO \n");

        ResultSet tiposProductos = st.executeQuery(traerTipoProducto);
        while (tiposProductos.next()) {
            tiposProudcttos.add(tiposProductos.getString("descrip"));
        }
        
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tiposProudcttos.size(); i++) {
            System.out.println((i + 1) + ": " + tiposProudcttos.get(i));
        }
System.out.println("Seleccione el producto: \n");
        int opcion = sc.nextInt();

        while (opcion < 1 || opcion > tiposProudcttos.size()) {
            System.out.println("opcion invalida");
                opcion = sc.nextInt(); 
        }
        
        PreparedStatement seleccionarProductoPorTIPo = con.prepareStatement("SELECT * FROM PRODUCT WHERE tipoproducto = ?");
        seleccionarProductoPorTIPo.setInt(1, opcion);
        tiposProductos = seleccionarProductoPorTIPo.executeQuery();
        
        while(tiposProductos.next()){
            System.out.println( tiposProductos.getString("name"));
        }

        //tiposProudcttos.forEach( tipo -> System.out.println(tipo));
        con.close();

    }

}
