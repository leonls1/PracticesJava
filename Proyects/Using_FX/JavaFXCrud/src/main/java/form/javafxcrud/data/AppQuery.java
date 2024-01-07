package form.javafxcrud.data;

import form.javafxcrud.model.Student;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Statement;
import java.sql.ResultSet;

public class AppQuery {

    private DBConnection db = new DBConnection();
    
    public void addStudent(Student student){
        try {
            db.getDBConection();
            PreparedStatement ps = db.getCon()                   
                    .prepareStatement
            ("INSERT into person(first_name, middle_name, surname) values(?,?,?)");
            
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getMiddleName());
            ps.setString(3, student.getSurname());
            ps.execute();
            ps.close();
            
            db.closeConn();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void removeStudent(int id){
        String query = "remove from human h where h.id = ?";
    }
    
    public ObservableList<Student> getStudents(){
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        
        try {
            
            String query = "SELECT * FROM person order by id";
            db.getDBConection();
            Statement st = db.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            Student stu ;
            
            while(rs.next()){
                stu = new Student(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("middle_name"),
                rs.getString("surname"));
                
                studentList.add(stu);
            }
            
            rs.close();
            st.close();
            db.closeConn();      
            
        } catch (Exception e) {
        }
        
        return studentList;
    }
    
}
