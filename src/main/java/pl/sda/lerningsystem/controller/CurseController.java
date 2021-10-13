package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.lerningsystem.entity.Course;
import pl.sda.lerningsystem.repository.CurseRepository;

import java.util.List;

@Controller
@RequestMapping("/curse")
public class CurseController {
    private  final CurseRepository curseRepository;
    public CurseController(CurseRepository curseRepository) {
        this.curseRepository = curseRepository;
    }
    @GetMapping("/listCurse")
    public String getViewCurse(Model model) {
        List<Course> courseList =curseRepository.findAll();
        model.addAttribute("curse", courseList);
        return "listCurse";
    }
    @GetMapping("/add")
    public String getAddCourse(){
        return "form2";
    }
    @PostMapping("/add")
    public String postCourse(@ModelAttribute("course") Course course){
        curseRepository.save(course);
        return "result2";
    }

}
