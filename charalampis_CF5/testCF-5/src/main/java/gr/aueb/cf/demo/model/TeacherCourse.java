package gr.aueb.cf.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a relationship between a teacher and a course.
 * Stores information about the association including id, teacher, course, teaching hours, and number of students.
 */
@Entity
@Table(name = "teachers_courses")
public class TeacherCourse {
    
    // ----------------------------------------------------------------------------------------------------
    // FIELDS
    // ----------------------------------------------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "teach_hrs")
    private int teachHrs;

    @Column(name = "num_of_studs")
    private int numOfStuds;

    // ----------------------------------------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------------------------------------
    
    public TeacherCourse() {}

    /**
     * Constructor for creating a TeacherCourse object with specified teacher, course, teaching hours, and number of students.
     * @param teacher the teacher associated with the course
     * @param course the course associated with the teacher
     * @param teachHrs the teaching hours allocated for the course
     * @param numOfStuds the number of students enrolled in the course
     */
    public TeacherCourse(Teacher teacher, Course course, int teachHrs, int numOfStuds) {
        this.teacher = teacher;
        this.course = course;
        this.teachHrs = teachHrs;
        this.numOfStuds = numOfStuds;
    }

    // ----------------------------------------------------------------------------------------------------
    // GETTERS AND SETTERS
    // ----------------------------------------------------------------------------------------------------
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getTeachHrs() {
        return teachHrs;
    }

    public void setTeachHrs(int teachHrs) {
        this.teachHrs = teachHrs;
    }

    public int getNumOfStuds() {
        return numOfStuds;
    }

    public void setNumOfStuds(int numOfStuds) {
        this.numOfStuds = numOfStuds;
    }
}
