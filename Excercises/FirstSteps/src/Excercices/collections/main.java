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
     
        clients.forEach((cli) -> 
            System.out.println(cli.getName() + "\n "
                    + "saldo" + cli.getTotalMoney()));
    }
/*
        Iterator<Client> it = clients.iterator();
        
        while(it.hasNext()){
            String name = it.next().getName();
            System.out.println("name: " + name);
            
        }*/
        
    }

