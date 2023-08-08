package eu.sana.EMERI.H.pojistovna.controller;

import eu.sana.EMERI.H.pojistovna.data.entities.ProductEntity;
import eu.sana.EMERI.H.pojistovna.data.repositories.ProductRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.mappers.ProductMapperInterface;
import eu.sana.EMERI.H.pojistovna.models.ProductDTO;
import eu.sana.EMERI.H.pojistovna.services.ProductService;
import eu.sana.EMERI.H.pojistovna.services.ProductServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")

public class ProductController {
    @Autowired
    ProductMapperInterface productMapperInterface;
    @Autowired
    ProductServiceInterface productServiceInterface;

    @GetMapping()
    public String renderProducts(Model model){
        List<ProductDTO> products = productServiceInterface.getAll();
model.addAttribute("products", products);
        return "pages/product";
    }
    @GetMapping("/newProduct")
    public String renderNewProduct(ProductDTO productDTO){

        return "pages/newProduct";
    }
    @PostMapping("/newProduct")
    public String createProduct(@Valid ProductDTO productDTO, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "chybně vyplněný formulař");
            return renderNewProduct(productDTO);
        }
        redirectAttributes.addFlashAttribute("success", "produkt úspěšně přidán");
        productServiceInterface.CreateProduct(productDTO);

        return "redirect:/products";
    }

    @GetMapping("/deleteProduct/{productId}")
public String deleteProduct(ProductDTO productDTO, @PathVariable long productId, RedirectAttributes redirectAttributes){
    productServiceInterface.deleteProduct(productId);
    redirectAttributes.addFlashAttribute("success","produkt byl odstranen z nabidky");
    return "redirect:/products";

}
@GetMapping("/editProduct/{productId}")
    public String editProduct(@PathVariable long productId, ProductDTO productDTO){
         ProductDTO product = productServiceInterface.getById(productId);
         productMapperInterface.updateProductDTO(product,productDTO);
        return "pages/editProduct";
}
@PostMapping("/editProduct/{productId}")
    public String updateProduct(@PathVariable long productId, @Valid  ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes ){
if(bindingResult.hasErrors()){
    redirectAttributes.addFlashAttribute("error","chyba formulaře");

    return editProduct(productId, productDTO);
}

        productDTO.setId(productId);
productServiceInterface.updateProduct(productDTO);
redirectAttributes.addFlashAttribute("success","produkt byl uspěšně aktualizován");
return "redirect:/products";
}
}
