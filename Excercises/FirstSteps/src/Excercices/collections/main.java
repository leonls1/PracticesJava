package Excercices.collections;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Client cli1 = new Client("leon", 1, 1500);
        Client clie2 = new Client("sasha", 2, 2000);
        Client clie3 = new Client("alexis", 3, 1750);
        Client clie4 = new Client("otro", 4, 3000);

        Set<Client> clients = new HashSet<Client>();

        clients.add(cli1);
        clients.add(clie2);
        clients.add(clie3);
        clients.add(clie4);    

        
        
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        
       
  
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        
         //iteradores para recorrer las listas
        ListIterator<String> it1 = list1.listIterator();
        ListIterator<String> it2 = list2.listIterator();       
        
        while(it2.hasNext()){
            if(it1.hasNext()){
                it1.next();
            }
            it1.add(it2.next());
        }
        
        list1.forEach(elem-> System.out.println(elem) );
        
    }

        
    }

