/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

import java.util.ArrayList;

/**
 *
 * @author leon
 */
public class Clase2 {

    public static void main(String[] args) {
        ToUpperCase toUpperCase = strings -> {
            ArrayList<String> upperCase = new ArrayList<>(strings);
            upperCase.replaceAll(String::toUpperCase);
            return upperCase;
        };

        ArrayList<String> strings = new ArrayList<>();
        strings.add("uno");
        strings.add("dos");
        strings.add("tres");
        
        strings.forEach(x -> System.out.println(x));

        toUpperCase.upper(strings).forEach(x -> System.out.println(x));

    }

    @FunctionalInterface
    interface ToUpperCase {

        ArrayList<String> upper(ArrayList<String> StringList);
    }

}
