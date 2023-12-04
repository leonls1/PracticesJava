package Excercices.collections;

import java.util.Comparator;


public class Client implements Comparable<Client>, Comparator<Client>{

    private String name;

    private int acountNumber;

    private double totalMoney;

    public Client(String name, int acountNumber, double totalMoney) {
        this.name = name;
        this.acountNumber = acountNumber;
        this.totalMoney = totalMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    
    /*
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client cli2 = (Client) obj;
            return (this.getAcountNumber() == cli2.getAcountNumber());
        } else {
            return false;
        }
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.acountNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        return this.acountNumber == other.acountNumber;
    }

    @Override
    public int compareTo(Client o) {
        return acountNumber - o.getAcountNumber(); }

    @Override
    public int compare(Client o1, Client o2) {
        String total1 = o1.getName();
        String total2 = o2.getName();
        
        return total1.compareTo(total2);
        
    }
    
    
    
    

}
