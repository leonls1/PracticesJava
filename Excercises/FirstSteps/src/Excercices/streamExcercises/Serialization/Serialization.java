package Excercices.streamExcercises.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class Serialization {

    public static void main(String[] args) {
        Empleado emp1 = new Empleado(0, "Leon", "Lederhos", Date.from(Instant.EPOCH));
        Empleado emp2 = new Empleado(0, "sasha", "Lederhos", Date.from(Instant.EPOCH));
        Empleado emp3 = new Empleado(0, "alexis", "Lederhos", Date.from(Instant.EPOCH));
        //wirting some objects
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\leonl\\Documents\\NetBeansProjects\\Excercises\\writingObjects.dat"));

            oos.writeObject(emp1);
            oos.writeObject(emp2);
            oos.writeObject(emp3);

            oos.close();
        } catch (Exception e) {
        }

        //reading other objects
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\leonl\\Documents\\NetBeansProjects\\Excercises\\writingObjects.dat"));
            System.out.println("readed");
            Empleado emp4 = (Empleado)ois.readObject();
            Empleado emp5 = (Empleado)ois.readObject();
            Empleado emp6 = (Empleado)ois.readObject();
            
            System.out.println(emp4.toString());
            System.out.println(emp5.toString());
            System.out.println(emp6.toString());
            
            ois.close();
          
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("not readed");
        }

    }
}

class Empleado implements Serializable {

    private int id;

    private String name, surname;

    private Date birthDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Empleado(int id, String name, String surname, Date birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Empleado() {
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + '}';
    }

}
