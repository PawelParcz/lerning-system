package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.lerningsystem.entity.Course;
import pl.sda.lerningsystem.repository.CourseRepository;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository curseRepository) {
        this.courseRepository = curseRepository;
    }

    @GetMapping("/list")
    public String getViewCourse(Model model) {
        List<Course> courseList = courseRepository.findAll();
        model.addAttribute("course", courseList);
        return "course/courseList";
    }

    @GetMapping("/add")
    public String getAddCourse() {
        return "course/courseForm";
    }

    @PostMapping(value = "/add")
    public String postCourse(@ModelAttribute("course") Course course) {
        courseRepository.save(course);
        return "course/courseResult";
    }
}
