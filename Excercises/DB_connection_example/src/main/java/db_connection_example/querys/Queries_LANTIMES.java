/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_connection_example.querys;

/**
 *
 * @author leon
 */
public class Queries_LANTIMES {

    //simpleQueries
    public String Simplequery1, Simplequery2, Simplequery3, Simplequery4, Simplequery5, Simplequery6, Simplequery7 = "";

    public Queries_LANTIMES() {
        Simplequery1 = """
                       SELECT o.ciudad, o.objetivo, o.ventas
                       FROM oficinas o;""";
        Simplequery2 = """
                       SELECT o.ciudad, o.objetivo, o.ventas
                       FROM oficinas o 
                       WHERE o.region = 'Oeste'""";
        Simplequery3 = """
                       SELECT o.ciudad, o.objetivo, o.ventas
                       FROM oficinas o 
                       WHERE o.region = 'Oeste' AND o.ventas > o.objetivo
                       ORDER BY o.ciudad;""";
        Simplequery4 = """
                       SELECT rv.nombre, rv.cuota, rv.cuota*1.03 as 'cuota elevada'
                       FROM repventas rv;""";
        Simplequery5 = """
                       SELECT o.ciudad, o.objetivo, o.ventas
                       FROM oficinas o 
                       WHERE o.ventas < o.objetivo*0.8
                       ORDER BY o.ciudad;""";
        Simplequery6 = """
                       SELECT rv.nombre
                       FROM repventas rv 
                       WHERE rv.oficina_rep IS NOT NULL;""";
        Simplequery7 = """
                       SELECT rv.nombre
                       FROM repventas rv 
                       WHERE (rv.oficina_rep IN (22, 11, 12) OR (rv.director IS NULL AND  YEAR(rv.contrato) = 1988 and MONTH(rv.contrato) = 6))
                       \t\tOR (rv.ventas > rv.cuota AND rv.ventas <= 600000);""";
    }

}
