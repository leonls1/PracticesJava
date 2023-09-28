/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests.genercic_programming;

/**
 *
 * @author leon
 */
public class GenericExample<T> {
    
    
    
    
    
    
    
        public GenericExample(){
            first = null;
        }
        
        public void setFirst(T newValue){
            first = newValue;
        }
        
        public T getFirst(){
            return first;
        }
        
        private T first;
}
