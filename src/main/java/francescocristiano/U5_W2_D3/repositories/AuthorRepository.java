package francescocristiano.U5_W2_D3.repositories;

import francescocristiano.U5_W2_D3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
