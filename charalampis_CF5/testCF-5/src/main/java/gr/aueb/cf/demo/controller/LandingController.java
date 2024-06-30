package gr.aueb.cf.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller handling various landing, login, and dashboard pages based on user roles.
 */
@Controller
public class LandingController {

    /**
     * Displays the landing page.
     * @return the view name for the landing page
     */
    @GetMapping("/")
    public String showLandingPage() {
        return "public/landing";
    }
    
    /**
     * Displays the home page.
     * @return the view name for the home page
     */
    @GetMapping("/public/home")
    public String showHomePage() {
        return "public/landing";
    }

    /**
     * Displays the login form page.
     * @return the view name for the login form page
     */
    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "public/loginForm";
    }
    
    /**
     * Displays the campus page.
     * @return the view name for the campus page
     */
    @GetMapping("public/campus")
    public String showCampusPage() {
        return "public/campus";
    }

    /**
     * Displays the news page.
     * @return the view name for the news page
     */
    @GetMapping("public/news")
    public String showNewsPage() {
        return "public/news";
    }
    
    /**
     * Displays the about page.
     * @return the view name for the about page
     */
    @GetMapping("public/about")
    public String showAboutPage() {
        return "public/about";
    }

    /**
     * Redirects users based on their roles after login.
     * @param authentication the authentication object containing user details
     * @return the redirect path based on user role
     */
    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/adminDashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TEACHER"))) {
            return "redirect:/teacher/teacherDashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
            return "redirect:/student/studentDashboard";
        }
        return "redirect:/public/landing";
    }
    
    /**
     * Displays the admin dashboard page.
     * @return the view name for the admin dashboard page
     */
    @GetMapping("/admin/adminDashboard")
    public String adminDashboard() {
        return "admin/adminDashboard";
    }

    /**
     * Displays the teacher dashboard page.
     * Retrieves the current username and adds it to the model.
     * @param model the model to add attributes to
     * @return the view name for the teacher dashboard page
     */
    @GetMapping("/teacher/teacherDashboard")
    public String teacherDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "teacher/teacherDashboard";
    }

    /**
     * Displays the student dashboard page.
     * Retrieves the current username and adds it to the model.
     * @param model the model to add attributes to
     * @return the view name for the student dashboard page
     */
    @GetMapping("/student/studentDashboard")
    public String studentDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "student/studentDashboard";
    }
}
