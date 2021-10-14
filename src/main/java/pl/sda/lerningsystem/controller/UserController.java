package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.lerningsystem.entity.User;
import pl.sda.lerningsystem.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public String getViewUsers(Model model) {
        List<User> list = repository.findAll();
        model.addAttribute("users", list);
        return "listUser";
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
