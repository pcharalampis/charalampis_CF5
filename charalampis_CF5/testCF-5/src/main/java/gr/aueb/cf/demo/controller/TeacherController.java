package gr.aueb.cf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller handling operations related to teachers.
 */
@Controller
public class TeacherController {

    /**
     * Redirects to the teacher dashboard page.
     * @param model the model to add attributes to
     * @return the redirect path to the teacher dashboard page
     */
    @GetMapping("/teacher/home")
    public String showTeacherHome(Model model) {
        return "redirect:/teacher/teacherDashboard";
    }

    /**
     * Displays the teacher courses page.
     * @param model the model to add attributes to
     * @return the view name for the teacher courses page
     */
    @GetMapping("/teacher/teacherCourses")
    public String showTeacherCourses(Model model) {
        return "teacher/teacherCourses";
    }
    
    /**
     * Displays the teacher lectures page.
     * @param model the model to add attributes to
     * @return the view name for the teacher lectures page
     */
    @GetMapping("/teacher/teacherLectures")
    public String showTeacherLectures(Model model) {
        return "teacher/teacherLectures";
    }
    
    /**
     * Displays the teacher students page.
     * @param model the model to add attributes to
     * @return the view name for the teacher students page
     */
    @GetMapping("/teacher/teacherStudents")
    public String showTeacherStudents(Model model) {
        return "teacher/teacherStudents";
    }
}
