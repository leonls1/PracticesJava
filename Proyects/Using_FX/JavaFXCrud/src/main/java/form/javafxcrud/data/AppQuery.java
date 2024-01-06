package form.javafxcrud.data;

import form.javafxcrud.model.Student;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppQuery {

    private DBConnection db = new DBConnection();
    
    public void addStudent(Student student){
        try {
            db.getDBConection();
            PreparedStatement ps = db.getCon()                   
                    .prepareStatement
            ("INSERT into person(first_name, middle_name, surname) values(?,?,?)");
            
            ps.setString(1, student.getFirtName());
            ps.setString(2, student.getMiddleName());
            ps.setString(3, student.getSurname());
            ps.execute();
            ps.close();
            
            db.closeConn();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
