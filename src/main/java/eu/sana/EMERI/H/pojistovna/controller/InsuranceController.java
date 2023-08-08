package eu.sana.EMERI.H.pojistovna.controller;

import eu.sana.EMERI.H.pojistovna.data.repositories.ClientRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.data.repositories.ProductRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.models.ClientDTO;
import eu.sana.EMERI.H.pojistovna.models.ProductDTO;
import eu.sana.EMERI.H.pojistovna.services.ClientServiceInterface;
import eu.sana.EMERI.H.pojistovna.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    ClientServiceInterface clientServiceInterface;
    @Autowired
    ProductServiceInterface productServiceInterface;
    @Autowired
    ClientRepositoryInterface clientRepositoryInterface;
    @Autowired
    ProductRepositoryInterface productRepositoryInterface;
    @GetMapping("/zivotko/{clientId}")
    public String renderZivotko(@PathVariable long clientId, Model model, RedirectAttributes redirectAttributes){
        ClientDTO clientDTO = clientServiceInterface.getById(clientId);
        model.addAttribute("client", clientDTO);
        List<ProductDTO> products = productServiceInterface.getAll();
        for(ProductDTO productDTO : products){
            if(productDTO.getName().equals("zivotni")){
                model.addAttribute("product", productDTO);
            }
        }

        return "insurance/zivot";
    }

}
