package eu.sana.EMERI.H.pojistovna.services;

import eu.sana.EMERI.H.pojistovna.models.ClientDTO;
import eu.sana.EMERI.H.pojistovna.models.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {
    ProductDTO getById(long productId);
    void CreateProduct(ProductDTO productDTO);
    List<ProductDTO> getAll();

    void deleteProduct(long productId);
    void updateProduct(ProductDTO productDTO);

}
