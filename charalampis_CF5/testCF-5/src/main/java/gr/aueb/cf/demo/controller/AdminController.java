package gr.aueb.cf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.aueb.cf.demo.model.Student;
import gr.aueb.cf.demo.model.Teacher;
import gr.aueb.cf.demo.service.StudentService;
import gr.aueb.cf.demo.service.TeacherService;

/**
 * Controller handling administrative functions for teachers and students.
 */
@Controller
public class AdminController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	// ------------------------------------------------------------------------------------------
	// Admin Management
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Displays the homepage for teacher management.
	 * Retrieves all teachers and adds them to the model.
	 */
	@GetMapping("/admin/teachManager")
	public String viewHomePage(Model model) {
		model.addAttribute("listTeachers", teacherService.getAllTeachers());
		return "admin/teachManager";
	}
	
	/**
	 * Displays the page for managing students.
	 * Retrieves all students and adds them to the model.
	 */
	@GetMapping("/admin/studManager")
	public String viewStudManagerPage(Model model) {
		model.addAttribute("listStudents", studentService.getAllStudents());
		return "admin/studManager";
	}
	
	// ------------------------------------------------------------------------------------------
	// Teacher CRUD Operations
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Displays the form for adding a new teacher.
	 * Initializes a new Teacher object and adds it to the model.
	 */
	@GetMapping("/admin/showNewTeacherForm")
	public String showNewTeacherForm(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "admin/newTeacher";
	}
	
	/**
	 * Saves a new teacher to the database.
	 * Redirects to the teacher management page on successful save.
	 */
	@PostMapping("/admin/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/admin/teachManager";
	}
	
	/**
	 * Displays the form for updating an existing teacher.
	 * Retrieves the teacher by ID and adds it to the model.
	 */
	@GetMapping("/admin/showUpdateTeacherForm/{id}")
	public String showUpdateTeacherForm(@PathVariable(value = "id") long id, Model model) {
		Teacher teacher = teacherService.getTeacherById(id);
		model.addAttribute("teacher", teacher);
		return "admin/updateTeacher";
	}
	
	/**
	 * Displays confirmation page before deleting a teacher.
	 * Retrieves the teacher by ID and adds it to the model.
	 */
	@GetMapping("/admin/confirmDeleteTeacher/{id}")
    public String confirmDeleteTeacher(@PathVariable(value = "id") long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "admin/confirmDeleteTeacher";
    }
	
	/**
	 * Deletes a teacher by ID from the database.
	 * Redirects to the teacher management page after deletion.
	 */
	@GetMapping("admin/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable(value = "id") long id, Model model) {
		this.teacherService.deleteTeacherById(id);	
		return "redirect:/admin/teachManager";
	}
	
	// ------------------------------------------------------------------------------------------
	// Student CRUD Operations
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Displays the form for adding a new student.
	 * Initializes a new Student object and adds it to the model.
	 */
	@GetMapping("/admin/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "admin/newStudent";
	}
	
	/**
	 * Saves a new student to the database.
	 * Redirects to the student management page on successful save.
	 */
	@PostMapping("/admin/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/admin/studManager";
	}
	
	/**
	 * Displays the form for updating an existing student.
	 * Retrieves the student by ID and adds it to the model.
	 */
	@GetMapping("/admin/showUpdateStudentForm/{id}")
	public String showUpdateStudentForm(@PathVariable(value = "id") long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "admin/updateStudent";
	}
	
	/**
	 * Displays confirmation page before deleting a student.
	 * Retrieves the student by ID and adds it to the model.
	 */
	@GetMapping("/admin/confirmDeleteStudent/{id}")
    public String confirmDeleteStudent(@PathVariable(value = "id") long id, Model model) {
		Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "admin/confirmDeleteStudent";
    }
	
	/**
	 * Deletes a student by ID from the database.
	 * Redirects to the student management page after deletion.
	 */
	@GetMapping("admin/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
		this.studentService.deleteStudentById(id);	
		return "redirect:/admin/studManager";
	}
	
	// ------------------------------------------------------------------------------------------
	// Other Administrative Functions
	// ------------------------------------------------------------------------------------------
		
	/**
	 * Displays the web management page for administrative tasks.
	 */
	@GetMapping("/admin/webManager")
	public String viewWebManager(Model model) {
		return "admin/webManager";
	}	
}
