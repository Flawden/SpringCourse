package ru.flawden.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.flawden.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping({"/{id}"})
    private String person(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("people", personDAO.person(id));
        return "/people/person";
    }

    @GetMapping()
    private String peopleList(Model model) {
        model.addAttribute("people", personDAO.peopleList());
        return "/people/people";
    }

}
