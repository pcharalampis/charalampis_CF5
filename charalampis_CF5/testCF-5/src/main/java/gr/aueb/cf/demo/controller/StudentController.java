package gr.aueb.cf.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import gr.aueb.cf.demo.model.StudentCourse;
import gr.aueb.cf.demo.model.User;
import gr.aueb.cf.demo.repository.CourseRepository;
import gr.aueb.cf.demo.repository.StudentCourseRepository;
import gr.aueb.cf.demo.repository.StudentRepository;
import gr.aueb.cf.demo.repository.UserRepository;

/**
 * Controller handling operations related to students.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Displays the list of courses a student is enrolled in.
     * Retrieves student-specific course data based on the logged-in user.
     * @param model the model to add attributes to
     * @param principal the principal object representing the logged-in user
     * @return the view name for the student courses page
     */
    @GetMapping("/student/studentCourses")
    public String showStudentCourses(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        List<StudentCourse> studentCourses = studentCourseRepository.findByStudentId(user.getId());
        model.addAttribute("studentCourses", studentCourses);
        return "student/studentCourses";
    }
    
    /**
     * Redirects to the student dashboard page.
     * @param model the model to add attributes to
     * @return the redirect path to the student dashboard page
     */
    @GetMapping("/student/home")
    public String showStudentHome(Model model) {
        return "redirect:/student/studentDashboard";
    }
    
    /**
     * Displays the student grades page.
     * @param model the model to add attributes to
     * @return the view name for the student grades page
     */
    @GetMapping("/student/studentGrades")
    public String showStudentGrades(Model model) {
        return "student/studentGrades";
    }
    
    /**
     * Displays the student progress page.
     * @param model the model to add attributes to
     * @return the view name for the student progress page
     */
    @GetMapping("/student/studentProgress")
    public String showStudentProgress(Model model) {
        return "student/studentProgress";
    }
}
