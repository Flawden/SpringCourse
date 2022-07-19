package ru.flawden.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.flawden.springcourse.dao.PersonDAO;
import ru.flawden.springcourse.models.Person;

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

    @GetMapping("/new")
    private String registration(@ModelAttribute("person") Person person) {
        return "/people/new_person";
    }

    @PostMapping()
    private String createPerson(@ModelAttribute Person person) {
        personDAO.createPerson(person);
        return "redirect:/people";
    }

}
