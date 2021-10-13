package pl.sda.lerningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.lerningsystem.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
