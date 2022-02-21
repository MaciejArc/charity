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

    public User registryNewAdmin(User user) {
        user.setRoles("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    public void lockUser(String id) {
        User user = userRepository.findById(Long.parseLong(id)).get();

        user.setNotLock(false);
        userRepository.save(user);

    }

    public User findByEmail(String email) {

        return userRepository.findUserByEmail(email).get();
    }

    public Optional<User> findByEmailOpt(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> userList() {
        return userRepository.findUsersByRoles("ROLE_USER");
    }


    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void editUser(User user) {
        User user1 = userRepository.findById(user.getId()).get();
        user.setPassword(user1.getPassword());
        userRepository.save(user);
    }
    public void editUserWithoutId(User oldUser,User user){
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        userRepository.save(oldUser);
    }

    public void editPassword(User oldUser,String password){
        oldUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(oldUser);
    }

    public void editAdmin(User user) {
        User user1 = userRepository.findById(user.getId()).get();
        user.setPassword(user1.getPassword());
        user.setRoles("ROLE_ADMIN");
        userRepository.save(user);
    }

    public List<User> adminList() {
        return userRepository.findUsersByRoles("ROLE_ADMIN");
    }

}
