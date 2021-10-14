package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.lerningsystem.entity.User;
import pl.sda.lerningsystem.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
    UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public String getViewUsers(@PathVariable("id") Long id, Model model) {
        User user = repository.getById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/add")
    public String getForm() {
        return "userForm";
    }

    @PostMapping(value = "/add")
    public String processForm(@ModelAttribute User users) {
        repository.save(users);
        return "userResult";
    }
}
