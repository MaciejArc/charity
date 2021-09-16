package pl.coderslab.charity.Service;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

@Configuration
public class UserServic {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServic(UserRepository userRepository, PasswordEncoder passwordEncoder) {
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
}
