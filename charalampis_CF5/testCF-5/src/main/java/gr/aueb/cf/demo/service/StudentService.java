package gr.aueb.cf.demo.service;

import java.util.List;
import gr.aueb.cf.demo.model.Student;

public interface StudentService {
	
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudentById(Long id);
    
}