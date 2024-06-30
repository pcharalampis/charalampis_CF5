package gr.aueb.cf.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Represents the association entity between Student and Course.
 * Contains information about student's attendance hours in a course.
 */
@Entity
@Table(name = "students_courses")
public class StudentCourse {

    // ----------------------------------------------------------------------------------------------------
    // FIELDS
    // ----------------------------------------------------------------------------------------------------
    
    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "attend_hrs", nullable = false)
    private int attendHrs;

    // ----------------------------------------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------------------------------------
    
    public StudentCourse() {}

    /**
     * Constructs a StudentCourse with the specified student, course, and attendance hours.
     * @param student the student enrolled in the course
     * @param course the course in which the student is enrolled
     * @param attendHrs the attendance hours of the student in the course
     */
    public StudentCourse(Student student, Course course, int attendHrs) {
        this.student = student;
        this.course = course;
        this.attendHrs = attendHrs;
    }

    // ----------------------------------------------------------------------------------------------------
    // GETTERS AND SETTERS
    // ----------------------------------------------------------------------------------------------------
    
    public StudentCourseKey getId() {
        return id;
    }

    public void setId(StudentCourseKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getAttendHrs() {
        return attendHrs;
    }

    public void setAttendHrs(int attendHrs) {
        this.attendHrs = attendHrs;
    }
}
