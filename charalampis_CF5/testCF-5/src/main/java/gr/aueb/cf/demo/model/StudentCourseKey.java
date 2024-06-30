package gr.aueb.cf.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Composite key class for StudentCourse entity.
 * Represents the primary key consisting of studentId and courseId.
 */
@Embeddable
public class StudentCourseKey implements Serializable {

    // ----------------------------------------------------------------------------------------------------
    // FIELDS
    // ----------------------------------------------------------------------------------------------------
    
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    // ----------------------------------------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------------------------------------
    
    public StudentCourseKey() {}

    /**
     * Constructs a composite key with the specified studentId and courseId.
     * @param studentId the ID of the student
     * @param courseId the ID of the course
     */
    public StudentCourseKey(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // ----------------------------------------------------------------------------------------------------
    // GETTERS AND SETTERS
    // ----------------------------------------------------------------------------------------------------
    
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    // ----------------------------------------------------------------------------------------------------
    // EQUALS AND HASHCODE
    // ----------------------------------------------------------------------------------------------------
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseKey that = (StudentCourseKey) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
