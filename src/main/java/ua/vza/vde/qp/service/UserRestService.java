package ua.vza.vde.qp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vza.vde.qp.dao.IUserDAO;
import ua.vza.vde.qp.obj.User;

/**
 * Created by SamsungR60P on 29.06.2015.
 */

@RestController
@RequestMapping("/api/userData")
public class UserRestService {

    @Autowired
    private IUserDAO userDAO;

    @RequestMapping("/getFio")
    public User getUserFioFromLoginRequersParam(@RequestParam(value = "login", required = false, defaultValue = "user")
                                    String userLogin){
        User user = userDAO.getUserFioByLogin(userLogin);
        return user;
    }

    @RequestMapping("/getFio/{putUserLogin}")
    public User getFioFromLoginPathParam(@PathVariable("putUserLogin") String userLogin){
        User user = userDAO.getUserFioByLogin(userLogin);
        return user;
    }
}
