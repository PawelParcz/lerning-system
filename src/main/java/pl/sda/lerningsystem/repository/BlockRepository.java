package pl.sda.lerningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.lerningsystem.entity.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
