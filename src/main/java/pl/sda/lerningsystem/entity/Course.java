package pl.sda.lerningsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCourse;
    //private List<Block> blockSubject;




    public String getNameCurse() {
        return nameCourse;
    }
}
