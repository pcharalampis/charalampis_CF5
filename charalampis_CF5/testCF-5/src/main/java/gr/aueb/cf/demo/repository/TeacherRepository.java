package gr.aueb.cf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.aueb.cf.demo.model.Teacher;

/**
 * Repository interface for performing CRUD operations on Teacher entities.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
}