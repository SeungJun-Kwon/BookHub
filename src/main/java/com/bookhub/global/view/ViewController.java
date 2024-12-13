package com.bookhub.global.view;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/test")
    public ModelAndView index() {
        System.out.println("test");
        ModelAndView result = new ModelAndView("test");

        result.addObject("test1", "test1");
        result.addObject("test2", List.of(1, 2, 3, 4, 5));

        return result;
    }
}
