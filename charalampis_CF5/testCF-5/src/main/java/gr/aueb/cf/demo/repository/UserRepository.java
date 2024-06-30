package gr.aueb.cf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.aueb.cf.demo.model.User;

/**
 * Repository interface for performing CRUD operations on User entities.
 * Includes a custom query to find a User by username.
 * @Query annotation is used to specify a JPQL query for finding a User by username.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}