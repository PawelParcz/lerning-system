package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.lerningsystem.entity.Lecture;
import pl.sda.lerningsystem.repository.LectureRepository;

@Controller
@RequestMapping("/lectures")
class LectureController {

    LectureRepository repository;

    public LectureController(LectureRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("lecture") Lecture lecture) {
        return "lecture/lectureForm";
    }

    @PostMapping("/add")
    public String processForm(@ModelAttribute("lecture") Lecture lecture) {
        repository.save(lecture);
        return "lecture/lectureResult";
    }
}
