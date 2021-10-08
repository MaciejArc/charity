package pl.coderslab.charity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Service.UserService;

@Service
public class CharityUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CharityUserDetailsService(UserService userService) {
        this.userService = userService;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

       return userService.findByEmail(s);

    }
}
