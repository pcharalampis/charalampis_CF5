package gr.aueb.cf.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.aueb.cf.demo.service.UserService;
import gr.aueb.cf.demo.web.dto.UserRegistrationDTO;

/**
 * Controller handling user registration operations.
 * Maps HTTP requests for user registration form and submission.
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Provides a model attribute for user registration data.
	 * @return An instance of UserRegistrationDTO initialized for form binding.
	 */
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}
	
	/**
	 * Handles GET requests to display the registration form.
	 * @return The logical view name of the registration form.
	 */
	@GetMapping
	public String showRegistrationForm() {
		return "public/registration";
	}
	
	/**
	 * Handles POST requests to process user registration.
	 * @param registrationDTO The DTO containing user registration data submitted from the form.
	 * @return Redirects to the registration page with a success message.
	 */
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO registrationDTO) {
		userService.save(registrationDTO);
		return "redirect:/registration?success";
	}

}
