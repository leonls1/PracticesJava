/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firststeps.Tests.genercic_programming;

/**
 *
 * @author leon
 */
import java.util.ArrayList;
import java.util.*;
public class Itera {
    ArrayList<example> arrayList = new ArrayList<example>();
    Iterator<example> ite = arrayList.listIterator();


}


class example{
    int count1;
    int count2;
    int count3; 

    public example() {
    }

    public example(int count1, int count2, int count3) {
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }

    public int getCount3() {
        return count3;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
    }
    
    
}
