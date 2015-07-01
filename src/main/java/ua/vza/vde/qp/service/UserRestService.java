package ua.vza.vde.qp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vza.vde.qp.dao.IUserDAO;
import ua.vza.vde.qp.obj.User;

import javax.ws.rs.*;

/**
 * Created by SamsungR60P on 29.06.2015.
 */

//@SuppressWarnings("ALL")
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/userData")
//@SuppressWarnings("SpringJavaAutowiringInspection")
//@Path("userData")
//@RequestScoped
public class UserRestService {

    @Autowired
    private IUserDAO userDAO;

//    @Inject
//    private SprProductNameCrud spnc;

    @RequestMapping(value ="/getFio", method = RequestMethod.GET)
//    @GET
//    @Path("getFio")
//    @Produces("application/json")
    public User getUserFioFromLoginRequersParam(@RequestParam(value = "login") String userLogin){
        User user = userDAO.getUserFioByLogin(userLogin);
        return user;
//        return Json.createObjectBuilder().add("fio", user.getFio()).build();
    }

    @RequestMapping(value = "/getFio/{userLogin}", method = RequestMethod.GET)
//    @GET
//    @Path("getFio/{userLogin}")
//    @Produces("application/json")
    public User getFioFromLoginPathParam(@PathParam("userLogin") String userLogin){
        User user = userDAO.getUserFioByLogin(userLogin);
        return user;
//        return Json.createObjectBuilder().add("fio", user.getFio()).build();
    }

}
