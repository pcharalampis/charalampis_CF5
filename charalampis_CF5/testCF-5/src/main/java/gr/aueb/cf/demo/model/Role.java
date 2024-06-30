package gr.aueb.cf.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a role entity in the system.
 */
@Entity
@Table(name = "roles")
public class Role {
    
    // ----------------------------------------------------------------------------------------------------
    // FIELDS
    // ----------------------------------------------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "role_name", nullable = false)
    private String roleName;

    // ----------------------------------------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------------------------------------
    
    public Role() {}
    
    /**
     * Constructor for creating a Role object with a specified role name.
     * @param roleName the name of the role
     */
    public Role(String roleName) {
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
