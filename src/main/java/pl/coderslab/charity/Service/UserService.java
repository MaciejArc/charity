package pl.coderslab.charity.Service;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Configuration
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registryNewAccount(User user) {

        User account = new User();
        account.setFirstName(user.getFirstName());
        account.setLastName(user.getLastName());
        account.setEmail(user.getEmail());
        account.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(account);
    }



    public User findByEmail(String email) {

        return userRepository.findUserByEmail(email).get();
    }
    public Optional<User> findByEmailOpt(String email){
        return userRepository.findUserByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> userList() {
        return userRepository.findAll();
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void editUser(User user){
        userRepository.save(user);
    }

}