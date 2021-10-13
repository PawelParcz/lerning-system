package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.lerningsystem.domain.User;
import pl.sda.lerningsystem.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute User user){
        return "form";
    }

    @PostMapping("/add")
    public String processForm(@ModelAttribute User user){
        repository.save(user);
        return "result";
    }

}
