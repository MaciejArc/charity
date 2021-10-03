package pl.coderslab.charity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Service.UserServic;

@Service
public class CharityUserDetailsService implements UserDetailsService {
    private final UserServic userServic;

    public CharityUserDetailsService(UserServic userServic) {
        this.userServic = userServic;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

       return userServic.findByEmail(s);

    }
}
