package repositories;

import com.iunetworks.entities.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<UUID, Country> {
}
