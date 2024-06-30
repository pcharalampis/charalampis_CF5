package gr.aueb.cf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.aueb.cf.demo.model.Student;

/**
 * Repository interface for performing CRUD operations on Student entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}