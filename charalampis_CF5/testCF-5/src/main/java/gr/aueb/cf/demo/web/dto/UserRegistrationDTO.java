package gr.aueb.cf.demo.web.dto;

/**
 * Data Transfer Object (DTO) for user registration information.
 * Holds data entered via registration form before it's saved as a User entity.
 */
public class UserRegistrationDTO {
	
	// ----------------------------------------------------------------------------------------------------
    // FIELDS
    // ----------------------------------------------------------------------------------------------------
    
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String role;
	
	// ----------------------------------------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------------------------------------
    
	public UserRegistrationDTO() {}
	
	/**
	 * Parameterized constructor to initialize all fields.
	 * @param firstName The first name of the user.
	 * @param lastName The last name of the user.
	 * @param email The email address of the user.
	 * @param username The username chosen by the user.
	 * @param password The password chosen by the user.
	 * @param role The role assigned to the user.
	 */
	public UserRegistrationDTO(String firstName, String lastName, String email, String username, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	// ----------------------------------------------------------------------------------------------------
    // GETTERS AND SETTERS
    // ----------------------------------------------------------------------------------------------------
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
