package ru.flawden.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

}
