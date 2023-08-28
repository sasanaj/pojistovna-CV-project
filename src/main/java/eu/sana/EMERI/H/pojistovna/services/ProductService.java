package eu.sana.EMERI.H.pojistovna.services;

import eu.sana.EMERI.H.pojistovna.data.entities.ProductEntity;
import eu.sana.EMERI.H.pojistovna.data.repositories.ProductRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.mappers.ProductMapperInterface;
import eu.sana.EMERI.H.pojistovna.models.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService implements ProductServiceInterface{
    @Autowired
    ProductRepositoryInterface productRepositoryInterface;
    @Autowired
    ProductMapperInterface productMapperInterface;


    @Override
    public ProductDTO getById(long productId) {
ProductEntity productEntity = productRepositoryInterface.findById(productId).orElseThrow();
        return productMapperInterface.toDTO(productEntity);
    }

    @Override
    public void CreateProduct(ProductDTO productDTO) {
ProductEntity newProduct = productMapperInterface.toEntity(productDTO);
productRepositoryInterface.save(newProduct);
    }

    @Override
    public List<ProductDTO> getAll() {

        return StreamSupport.stream(productRepositoryInterface.findAll().spliterator(), false).map(i -> productMapperInterface.toDTO(i)).toList();
    }

    @Override
    public void deleteProduct(long productId) {
        productRepositoryInterface.deleteById(productId);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        ProductEntity fetchedProduct = productRepositoryInterface.findById(productDTO.getId()).orElseThrow();
productMapperInterface.updateProductEntity(productDTO, fetchedProduct);
        productRepositoryInterface.save(fetchedProduct);



        }

    }


