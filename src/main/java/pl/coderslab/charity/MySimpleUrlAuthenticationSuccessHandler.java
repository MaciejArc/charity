package pl.coderslab.charity;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.coderslab.charity.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User principal =(User) authentication.getPrincipal();
        String roles = principal.getRoles();
        if(roles.equals("ROLE_ADMIN")){
            httpServletResponse.sendRedirect("/admin/dashboard");
        }else {
            httpServletResponse.sendRedirect("/");
        }
    }
}
