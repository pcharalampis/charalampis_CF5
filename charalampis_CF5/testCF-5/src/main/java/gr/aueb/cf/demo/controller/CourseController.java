package gr.aueb.cf.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import gr.aueb.cf.demo.model.Course;
import gr.aueb.cf.demo.repository.CourseRepository;

/**
 * Controller for handling courses related functionality.
 */
@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Retrieves all courses from the repository and adds them to the model.
     * @param model to add the list of courses.
     * @return the view name for displaying the list of courses
     */
    @GetMapping("/public/courses")
    public String listCourses(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "public/courses";
    }
}
