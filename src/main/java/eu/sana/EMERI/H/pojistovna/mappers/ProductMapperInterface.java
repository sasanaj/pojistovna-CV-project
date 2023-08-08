package eu.sana.EMERI.H.pojistovna.mappers;

import eu.sana.EMERI.H.pojistovna.data.entities.ClientEntity;
import eu.sana.EMERI.H.pojistovna.data.entities.ProductEntity;
import eu.sana.EMERI.H.pojistovna.models.ClientDTO;
import eu.sana.EMERI.H.pojistovna.models.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProductMapperInterface {
    ProductEntity toEntity(ProductDTO productDTO);
ProductDTO toDTO(ProductEntity productEntity);
    void updateProductDTO(ProductDTO source, @MappingTarget ProductDTO target);
    void updateProductEntity(ProductDTO source, @MappingTarget ProductEntity target);


}
