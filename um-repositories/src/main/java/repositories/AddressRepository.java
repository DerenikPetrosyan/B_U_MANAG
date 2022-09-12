package repositories;

import com.iunetworks.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<UUID, Address> {
}
