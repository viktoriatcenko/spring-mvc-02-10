package ru.maxima.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.maxima.dao.PersonDAO;
import ru.maxima.model.Person;

// localhost:8080

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // CRUD - create read update delete

    // @PostMapping - create
    // @GetMapping - read
    // @PutMapping - update
    // @PatchMapping - update
    // @DeleteMapping - delete

    @GetMapping()
    public String showAllPeople(Model model) {
        model.addAttribute("allPeople", personDAO.getAllPeople());
        return "view-with-all-people";
    }

    @GetMapping("/{id}")
    public String showPersonById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("personById", personDAO.findById(id));
        return "view-with-person-by-id";
    }

    @GetMapping("/new")
    public String giveToUserPageToCreateNewPerson(Model model) {
        model.addAttribute("newPerson", new Person());
        return "view-to-create-new-person";
    }

    @PostMapping()
    public String createNewPerson(@ModelAttribute("newPerson") @Valid Person person, BindingResult binding) {
        if (binding.hasErrors()) {
            return "view-to-create-new-person";
        }
        personDAO.save(person);
        return "redirect:/people";

    }

    @GetMapping("/{id}/edit")
    public String giveToUserPageToEditPerson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editedPerson", personDAO.findById(id));
        return "view-to-edit-person";
    }

    @PostMapping("/{id}")
    public String updateEditedPerson(@PathVariable("id") Long id,
                                     @ModelAttribute("editedPerson") @Valid Person editedPerson, BindingResult binding) {
        if (binding.hasErrors()) {
            return "view-to-edit-person";
        }
        personDAO.update(id, editedPerson);
        return "redirect:/people";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personDAO.deleteById(id);
        return "redirect:/people";
    }




}
