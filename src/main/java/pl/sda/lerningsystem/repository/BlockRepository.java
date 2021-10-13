package pl.sda.lerningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.lerningsystem.domain.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
