package pl.sda.lerningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.lerningsystem.domain.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
