package gr.aueb.cf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.aueb.cf.demo.model.Course;

/**
 * Repository interface for performing CRUD operations on Course entities.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
	
}