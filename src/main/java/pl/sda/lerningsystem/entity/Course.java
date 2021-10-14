package pl.sda.lerningsystem.entity;


import javax.persistence.*;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameBlock;


    public String getName() {
        return name;
    }

    public String getNameBlock() {
        return nameBlock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBlock(String nameBlock) {
        this.nameBlock = nameBlock;
    }
}
