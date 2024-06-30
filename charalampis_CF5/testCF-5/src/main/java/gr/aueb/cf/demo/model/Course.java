package gr.aueb.cf.demo.model;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a course entity in the system.
 */
@Entity
@Table(name = "courses")
public class Course {
    
    // ----------------------------------------------------------------------------------------------------
    // FIELDS
    // ----------------------------------------------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "attend_hrs_max", nullable = false)
    private int attendHrsMax;

    @Column(name = "attend_hrs_min", nullable = false)
    private int attendHrsMin;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<StudentCourse> studentCourses;

    // ----------------------------------------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------------------------------------
    
    public Course() {}

    /**
     * Constructor for creating a Course object with specified name, description, maximum attendance hours,
     * minimum attendance hours, and associated student courses.
     * @param name the name of the course
     * @param description the description of the course
     * @param attendHrsMax the maximum attendance hours for the course
     * @param attendHrsMin the minimum attendance hours for the course
     * @param studentCourses the set of student courses associated with the course
     */
    public Course(String name, String description, int attendHrsMax, int attendHrsMin,
                  Set<StudentCourse> studentCourses) {
        this.name = name;
        this.description = description;
        this.attendHrsMax = attendHrsMax;
        this.attendHrsMin = attendHrsMin;
        this.studentCourses = studentCourses;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttendHrsMax() {
        return attendHrsMax;
    }

    public void setAttendHrsMax(int attendHrsMax) {
        this.attendHrsMax = attendHrsMax;
    }

    public int getAttendHrsMin() {
        return attendHrsMin;
    }

    public void setAttendHrsMin(int attendHrsMin) {
        this.attendHrsMin = attendHrsMin;
    }

    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
