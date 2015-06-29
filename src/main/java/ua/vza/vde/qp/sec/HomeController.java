package ua.vza.vde.qp.sec;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import ua.vza.vde.qp.impl.UserImplDAO;
import ua.vza.vde.qp.obj.User;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.security.Principal;

/**
 * Created by velenteenko on 23.06.15.
 */

@Controller
public class HomeController {

    @Autowired
    ApplicationContext context;

//    @Autowired
//    UserImplDAO implDAO;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String homeSetUp(Model model)  {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String nameUser = authentication.getName();
        String toString = authentication.toString();

        model.addAttribute("username", nameUser);
        model.addAttribute("toString", toString);

//        UserImplDAO dao =  (UserImplDAO)context.getBean("userImplDAO");

//        User user = implDAO.getUserFioByLogin(nameUser);

//        model.addAttribute("fio", user.getFio());

        return "home";
    }

    @RequestMapping(value = "/accessdenided.page403", method = RequestMethod.GET)
    public ModelAndView accessDenided(Principal user) {
//        model.addAttribute("logIn","Войти");

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Здравствуйте, " + user.getName() + " Вы не имеете права просматривать эту страницу!");
        } else {
            model.addObject("msg", "Вы не имеете права просматривать эту страницу!");
        }

        model.addObject("logIn", "Войти");

        //
        model.setViewName("403page");
        return model;
    }
}
