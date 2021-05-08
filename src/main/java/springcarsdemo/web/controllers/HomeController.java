package springcarsdemo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home (ModelAndView modelAndView){

//        modelAndView.addObject("names", new String[]{"Kalin", "Bobo"});

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
