package repositories;

import com.iunetworks.entities.address.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<UUID, City> {
}
