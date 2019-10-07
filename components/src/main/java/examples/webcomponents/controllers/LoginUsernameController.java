package examples.webcomponents.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Collections.singletonMap;

@Controller
public class LoginUsernameController {

    private static final String LOGIN_NAME_VIEW = "login-name";

    @RequestMapping(path = "/components/login-name.js", produces = "application/javascript")
    public ModelAndView username(Authentication authentication) {
        if (authentication == null) {
            return new ModelAndView(LOGIN_NAME_VIEW);
        }
        return new ModelAndView(LOGIN_NAME_VIEW, singletonMap("username", authentication.getName()));
    }
}
