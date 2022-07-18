package ru.flawden.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "first/hello";
    }

    @GetMapping("/welcome")
    public String sayHello(HttpServletRequest request, Model model) {
        model.addAttribute("name", request.getParameter("name"));
        return "first/hello";
    }

    @GetMapping("/welcome-alter")
    public String sayHello(@RequestParam(required = false, name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(name = "a") Double a, @RequestParam(name = "b") Double b, @RequestParam(name = "action") String action, Model model) {
        if (action.equalsIgnoreCase("addition")) {
            model.addAttribute("result", a + b);
        } else if (action.equalsIgnoreCase("subtraction")) {
            model.addAttribute("result", a - b);
        } else if (action.equalsIgnoreCase("division")) {
            model.addAttribute("result", a / b);
        } else if (action.equalsIgnoreCase("multiplication")) {
            model.addAttribute("result", a * b);
        } else {
            model.addAttribute("result", "Incorrect value for one of the fields.\n" +
                    "\n" +
                    "The input must contain:\n" +
                    "a - number\n" +
                    "b - number\n" +
                    "action - action (addition, subtraction, division, multiplication)");
        }
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

}
