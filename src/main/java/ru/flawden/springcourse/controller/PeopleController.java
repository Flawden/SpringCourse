package ru.flawden.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.flawden.springcourse.dao.PersonDAO;
import ru.flawden.springcourse.models.Person;
import ru.flawden.springcourse.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final PersonValidator personValidator;

    public PeopleController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }

    @GetMapping({"/{id}"})
    private String person(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "/people/person";
    }

    @GetMapping({"/{id}/edit"})
    private String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    private String updatePerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") Integer id) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/people/edit";
        }
        personDAO.updatePerson(person, id);
        return "redirect:/people";
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
    private String createPerson(@ModelAttribute @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/people/new_person";
        }
        personDAO.createPerson(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

}
