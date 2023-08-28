package eu.sana.EMERI.H.pojistovna.data.repositories;

import eu.sana.EMERI.H.pojistovna.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepositoryInterface extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
