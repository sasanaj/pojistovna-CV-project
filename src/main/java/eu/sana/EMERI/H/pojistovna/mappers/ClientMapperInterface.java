package eu.sana.EMERI.H.pojistovna.mappers;

import eu.sana.EMERI.H.pojistovna.data.entities.ClientEntity;
import eu.sana.EMERI.H.pojistovna.models.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ClientMapperInterface {
    ClientEntity toEntity(ClientDTO clientDTO);
    ClientDTO toDTO(ClientEntity clientEntity);

    void updateClientDTO(ClientDTO source, @MappingTarget ClientDTO target);
    void updateClientEntity(ClientDTO source, @MappingTarget ClientEntity target);

}
