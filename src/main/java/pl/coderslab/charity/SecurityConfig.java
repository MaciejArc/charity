package pl.coderslab.charity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final CharityUserDetailsService charityUserDetailsService;

    public SecurityConfig(CharityUserDetailsService charityUserDetailsService) {
        this.charityUserDetailsService = charityUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(charityUserDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/form").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/");
    }
}
