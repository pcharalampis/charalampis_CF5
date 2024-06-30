package gr.aueb.cf.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // ----------------------------------------------------------------------------------------------------
    // BEAN DEFINITIONS
    // ----------------------------------------------------------------------------------------------------

    /**
     * Defines the security filter chain configuration.
     * Configures HTTP security rules for different paths and roles.
     * Disables CSRF protection for simplicity.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/landing", "/loginForm", "/registration", "/campus", "/assets/**", "/images/**", "/css/**", "/js/**").permitAll() // Allow access to login page without authentication
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/teacher/**").hasRole("TEACHER")
                .requestMatchers("/student/**").hasRole("STUDENT")
                .anyRequest().authenticated() // All other pages require authentication
            )
            .formLogin(form -> form
                .loginPage("/loginForm")
                .defaultSuccessUrl("/default", true)
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll() // Allow everyone to log out
            );
        
        return http.build();
    }

    /**
     * Provides user details service with predefined users.
     * Uses in-memory storage for simplicity.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // Define user details for admin, teacher, and student
    	
    	// ----------------------------------------------------------------------------------------------------
    	// [*] Currently only these 3 test users can successfully login.
    	// New users can be created through the registration page and stored in the database,
    	// but I haven't connected this logic.
    	// ----------------------------------------------------------------------------------------------------
    	
        UserDetails admin = User.withUsername("palpatine")
            .password(passwordEncoder().encode("12345"))
            .roles("ADMIN")
            .build();

        UserDetails teacher = User.withUsername("obiwan")
            .password(passwordEncoder().encode("1234"))
            .roles("TEACHER")
            .build();

        UserDetails student = User.withUsername("anakin")
            .password(passwordEncoder().encode("123"))
            .roles("STUDENT")
            .build();

        return new InMemoryUserDetailsManager(admin, teacher, student);
    }

    /**
     * Provides a password encoder bean for encoding passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
