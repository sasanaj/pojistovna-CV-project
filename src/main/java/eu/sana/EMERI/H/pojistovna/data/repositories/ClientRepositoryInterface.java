package eu.sana.EMERI.H.pojistovna.data.repositories;

import eu.sana.EMERI.H.pojistovna.data.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepositoryInterface extends CrudRepository<ClientEntity, Long> {
}
