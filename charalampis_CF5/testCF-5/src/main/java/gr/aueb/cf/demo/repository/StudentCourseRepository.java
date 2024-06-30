package gr.aueb.cf.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gr.aueb.cf.demo.model.StudentCourse;
import gr.aueb.cf.demo.model.StudentCourseKey;

/**
 * Repository interface for performing CRUD operations on StudentCourse entities.
 * Includes a custom query to find StudentCourse entities by studentId.
 * @Query annotation is used to specify a JPQL query for finding StudentCourse entities by studentId.
 */
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseKey> {

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId")
    List<StudentCourse> findByStudentId(@Param("studentId") Long studentId);
    
}