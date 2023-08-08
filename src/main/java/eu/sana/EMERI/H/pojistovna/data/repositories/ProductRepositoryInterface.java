package eu.sana.EMERI.H.pojistovna.data.repositories;

import eu.sana.EMERI.H.pojistovna.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepositoryInterface extends CrudRepository<ProductEntity, Long> {
}
