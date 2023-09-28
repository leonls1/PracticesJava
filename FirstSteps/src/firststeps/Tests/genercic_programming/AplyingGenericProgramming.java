/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests.genercic_programming;
import firststeps.Tests.genercic_programming.GenericExample;

/**
 *
 * @author leon
 */
public class AplyingGenericProgramming {
    public static void main(String[] args) {
       GenericExample<String> one = new GenericExample<String>() ; //create a new instance of the class will null value
       one.setFirst("Leon");        
       System.out.println(one.getFirst());
       
       People aPerson = new People("Sasha");
       GenericExample<People> another = new GenericExample<People>();
       another.setFirst(aPerson);
        
        
    }
    
    
    
    
    static class People{

        public People() {
        }

        public People(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        
        
        private String name;
       
    }
}
