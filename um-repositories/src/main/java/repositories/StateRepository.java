package repositories;

import com.iunetworks.entities.address.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<UUID, State> {
}
