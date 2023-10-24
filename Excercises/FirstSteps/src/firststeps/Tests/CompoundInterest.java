/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests;

/**
 *
 * @author leon
 */
public class CompoundInterest {
    public static void main(String[] args){
        
        double salarios[][] = new double[5][5];
        
        salarios[0][0] =10000;
        salarios[0][1] =10000;
        salarios[0][2] =10000;
        salarios[0][3] =10000;
        salarios[0][4] =10000;
        
        for(int i=1; i<5; i++){
            for(int j=0; j<5; j++){
                salarios[i][j] = salarios[i-1][j]*((10.0+j)/100.0+1);
            }
        }
        for(double row[]:salarios){
            System.out.println("");
            for(double salary:row){
                System.out.println(salary);
            }                
        }
    }
}
