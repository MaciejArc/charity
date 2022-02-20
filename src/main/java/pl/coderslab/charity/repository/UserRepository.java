package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    List<User> findUsersByRoles(String role);

}
