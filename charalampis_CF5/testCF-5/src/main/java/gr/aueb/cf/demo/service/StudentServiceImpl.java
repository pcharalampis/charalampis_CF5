package gr.aueb.cf.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.aueb.cf.demo.model.Student;
import gr.aueb.cf.demo.repository.StudentRepository;

/**
 * Implements the StudentService interface to provide CRUD operations for Student entities.
 * Uses StudentRepository for data access.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Retrieves all students from the database.
     *
     * @return List of all students
     */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param id The ID of the student to retrieve
     * @return The student if found, otherwise null
     */
    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    /**
     * Saves a student into the database.
     *
     * @param student The student to save
     * @return The saved student
     */
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Deletes a student from the database by their ID.
     *
     * @param id The ID of the student to delete
     */
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
