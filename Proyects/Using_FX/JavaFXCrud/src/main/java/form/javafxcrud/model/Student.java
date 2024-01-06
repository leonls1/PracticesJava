package form.javafxcrud.model;


public class Student {

    public int id;
    
    public String firtName;
    
    public String middleName;
    
    public String surname;

    public Student(String firtName, String middleName, String surname) {
        this.firtName = firtName;
        this.middleName = middleName;
        this.surname = surname;
    }

    public Student(int id, String firtName, String middleName, String surname) {
        this.id = id;
        this.firtName = firtName;
        this.middleName = middleName;
        this.surname = surname;
    }
    
    

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
