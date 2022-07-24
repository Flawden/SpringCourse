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

    @GetMapping()
    private String showAllPeople(Model model) {
        model.addAttribute("people", personDAO.showAllPeople());
        return "/people/people";
    }

    @GetMapping("/new")
    private String showCreatePage(@ModelAttribute("person") Person person) {
        return "/people/new_person";
    }

    @PostMapping()
    private String create(@ModelAttribute @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/people/new_person";
        }
        personDAO.create(person);
        return "redirect:/people";
    }

    @GetMapping({"/{id}"})
    private String show(@PathVariable("id") Integer personId, Model model) {
        model.addAttribute("person", personDAO.show(personId));
        return "/people/person";
    }

    @GetMapping({"/{id}/edit"})
    private String edit(@PathVariable("id") Integer personId, Model model) {
        model.addAttribute("person", personDAO.show(personId));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    private String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") Integer personId) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/people/edit";
        }
        personDAO.updatePerson(person, personId);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

}
