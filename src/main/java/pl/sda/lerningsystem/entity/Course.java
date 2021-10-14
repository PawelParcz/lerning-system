package pl.sda.lerningsystem.entity;


import javax.persistence.*;
import java.util.List;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCourse;
    private String nameBlock;


    public String getNameCourse() {
        return nameCourse;
    }

    public String getNameBlock() {
        return nameBlock;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public void setNameBlock(String nameBlock) {
        this.nameBlock = nameBlock;
    }
}
