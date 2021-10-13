package pl.sda.lerningsystem.entity;


import javax.persistence.*;
import java.util.List;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nameCourse;

    //private Block blockSubject;




    public String getNameCurse() {
        return nameCourse;
    }
}
