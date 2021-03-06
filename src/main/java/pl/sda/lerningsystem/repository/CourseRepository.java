package pl.sda.lerningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.lerningsystem.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
