package eu.sana.EMERI.H.pojistovna.data.repositories;

import eu.sana.EMERI.H.pojistovna.data.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRespositoryInterface extends CrudRepository<OrderEntity, Long>{
}
