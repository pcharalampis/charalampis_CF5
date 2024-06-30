package gr.aueb.cf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gr.aueb.cf.demo.model.Role;

/**
 * Repository interface for performing CRUD operations on Role entities.
 * Includes a custom query to find a Role by its roleName.
 * @Query annotation is used to specify a JPQL query for finding a Role by its roleName attribute.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.roleName = :roleName")
    Role findByRoleName(@Param("roleName") String roleName);
    
}
