package pl.sda.lerningsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/edit")
    public String getForm(@PathVariable("id") Long id, Model model) {
        var lecture = repository.findById(id).orElseThrow(() -> new RuntimeException("There is NOTHING!"));
        model.addAttribute("lecture", lecture);
        return "lectureEditForm";
    }

    @PostMapping("/{id}/edit")
    public String proceedForm(@PathVariable("id") Long id,@ModelAttribute Lecture editedValuesLecture) {
        Lecture lecture = repository.getById(id);
        lecture.setName(editedValuesLecture.getName());
        lecture.setDate(editedValuesLecture.getDate());
        repository.save(lecture);
        return "lectureEditResult";
    }
}
