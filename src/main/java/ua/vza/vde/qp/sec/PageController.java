package ua.vza.vde.qp.sec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by velenteenko on 03.07.15.
 */

@Controller
public class PageController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allProduct(Model model){
        return "all";
    }

    @RequestMapping(value = "/himiya", method = RequestMethod.GET)
    public String chemistry(Model model){
        return "chemistry";
    }

    @RequestMapping(value = "/complect", method = RequestMethod.GET)
    public String complect(Model model){
        return "complect";
    }
    @RequestMapping(value = "/metal", method = RequestMethod.GET)
    public String metall(Model model){
        return "metall";
    }

    @RequestMapping(value = "/metiz", method = RequestMethod.GET)
    public String metiz(Model model){
        return "metiz";
    }

    @RequestMapping(value = "/nemetal", method = RequestMethod.GET)
    public String nometal(Model model){
        return "nometall";
    }

    @RequestMapping(value = "/setkaLentaProvoloka", method = RequestMethod.GET)
    public String setkaLentaProvoloka(Model model){
        return "setka";
    }

}
