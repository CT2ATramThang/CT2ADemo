
package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReturnHomeController {
    @RequestMapping(value="/homePage", method = RequestMethod.GET)
    public String showAirPortStationForm( Model model){
        
        return "redirect:/";
    }
}
