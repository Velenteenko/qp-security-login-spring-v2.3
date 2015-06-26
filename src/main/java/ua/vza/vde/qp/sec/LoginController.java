package ua.vza.vde.qp.sec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by velenteenko on 24.06.15.
 */

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.HEAD})
    public String logInStart(Model model) {

        return "login";
    }
}
