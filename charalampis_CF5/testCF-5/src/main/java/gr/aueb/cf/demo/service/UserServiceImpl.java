package gr.aueb.cf.demo.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import gr.aueb.cf.demo.model.Role;
import gr.aueb.cf.demo.model.User;
import gr.aueb.cf.demo.repository.RoleRepository;
import gr.aueb.cf.demo.repository.UserRepository;
import gr.aueb.cf.demo.web.dto.UserRegistrationDTO;

/**
 * Implements the UserService interface to provide user registration functionality.
 * Saves users with encoded passwords and assigns roles based on registration data.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Saves a new user based on the provided registration DTO.
     *
     * @param registrationDTO The DTO containing user registration data
     * @return The saved User entity
     */
    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        // Fetch role from the repository based on the role name provided in the DTO
        Role role = roleRepository.findByRoleName(registrationDTO.getRole());

        // Assign the fetched role to the user
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        // Save the user entity to the database
        return userRepository.save(user);
    }
}
