package pl.sda.lerningsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.lerningsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
