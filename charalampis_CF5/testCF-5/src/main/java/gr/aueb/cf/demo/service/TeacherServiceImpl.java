package gr.aueb.cf.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.aueb.cf.demo.model.Teacher;
import gr.aueb.cf.demo.repository.TeacherRepository;

/**
 * Implements the TeacherService interface to provide CRUD operations for Teacher entities.
 * Uses TeacherRepository for data access.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * Retrieves all teachers from the database.
     *
     * @return List of all teachers
     */
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    /**
     * Saves a teacher into the database.
     *
     * @param teacher The teacher to save
     */
    @Override
    public void saveTeacher(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    /**
     * Retrieves a teacher by their ID.
     *
     * @param id The ID of the teacher to retrieve
     * @return The teacher if found
     * @throws RuntimeException if teacher with the given ID is not found
     */
    @Override
    public Teacher getTeacherById(long id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        Teacher teacher = null;
        if (optional.isPresent()) {
            teacher = optional.get();
        } else {
            throw new RuntimeException("Teacher with id [" + id + "] not found.");
        }
        return teacher;
    }

    /**
     * Deletes a teacher from the database by their ID.
     *
     * @param id The ID of the teacher to delete
     */
    @Override
    public void deleteTeacherById(Long id) {
        this.teacherRepository.deleteById(id);
    }
}
