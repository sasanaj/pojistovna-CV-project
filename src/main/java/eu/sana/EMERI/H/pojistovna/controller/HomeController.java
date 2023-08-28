package eu.sana.EMERI.H.pojistovna.controller;

import eu.sana.EMERI.H.pojistovna.mappers.ClientMapperInterface;
import eu.sana.EMERI.H.pojistovna.models.ClientDTO;
import eu.sana.EMERI.H.pojistovna.models.exeptions.ClientNotFoundException;
import eu.sana.EMERI.H.pojistovna.services.ClientServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    ClientServiceInterface clientServiceInterface;

    @Autowired
    ClientMapperInterface clientMapperInterface;

    @GetMapping("/home")
    public String printHome(ClientDTO clientDTO, RedirectAttributes redirectAttributes){
        return "pages/index";
    }
    @PostMapping("/home")
    public String createClient(@Valid ClientDTO clientDTO, BindingResult result, RedirectAttributes redirectAttributes){
       redirectAttributes.addFlashAttribute("success", "test zde");
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("error","chyba formulare");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.clientDTO", result);

return printHome(clientDTO, redirectAttributes);
        }
        clientServiceInterface.create(clientDTO);
        redirectAttributes.addFlashAttribute("success", "Klient byl přidán");
        return "redirect:/stats";

    }
    @PostMapping("/search")
    public String handleSearch(ClientDTO clientDTO, RedirectAttributes redirectAttributes, Model model){
            String prijmeni = clientDTO.getPrijmeni();
            String email = clientDTO.getEmail();
            String telefon = clientDTO.getTelefon();
            String jmeno = clientDTO.getJmeno();
            String name = prijmeni + email + telefon + jmeno;

        List<ClientDTO> clients = clientServiceInterface.searchResult(name);
        model.addAttribute("clients", clients);

        return "pages/searchResult";
    }
   /* @PostMapping("/profile/{clientId}")
    public String search(@PathVariable long clientId, Model model){
        String jmeno = clientDTO.getJmeno();
        List<ClientDTO>seznam = clientServiceInterface.getAll();
        for(ClientDTO client:seznam) {
            if (client.getJmeno().equalsIgnoreCase(jmeno)) {
                return "pages/profile/" + client.getClientId();
            }


        }
        return "pages/index";

        ClientDTO clientDTO = clientServiceInterface.getById(clientId);
        model.addAttribute("client", clientDTO);
        return "pages/profile";
    }*/
    @Secured("ROLE_ADMIN")
@GetMapping("/profile/{clientId}")
public String showDetail(@PathVariable long clientId, Model model, RedirectAttributes redirectAttributes){
ClientDTO clientDTO = clientServiceInterface.getById(clientId);
model.addAttribute("client", clientDTO);
    return "pages/profile";
}


    @Secured("ROLE_ADMIN")

    @GetMapping("/stats")
    public String renderStats(Model model, RedirectAttributes redirectAttributes){
        List<ClientDTO> clients = clientServiceInterface.getAll();
        model.addAttribute("clients", clients);
        return "pages/stats";
    }

    @GetMapping("/edit/{clientId}")
    public String renderUpdate(@PathVariable Long clientId, ClientDTO clientDTO, RedirectAttributes redirectAttributes){
            ClientDTO fetchedClient = clientServiceInterface.getById(clientId);
            clientMapperInterface.updateClientDTO(fetchedClient, clientDTO);

        return "pages/edit";
    }
    @PostMapping("/edit/{clientId}")
    public String editingClient(@PathVariable long clientId, @Valid ClientDTO clientDTO, BindingResult result, RedirectAttributes redirectAttributes){
            if(result.hasErrors()){
                return renderUpdate(clientId, clientDTO, redirectAttributes);
            }
            clientDTO.setClientId(clientId);
            clientServiceInterface.editClient(clientDTO);
        redirectAttributes.addFlashAttribute("success", "Data byla aktualizována");

        return "redirect:/stats";
    }
    @GetMapping("/delete/{clientId}")
    public String deleteClient(@PathVariable long clientId, @Valid ClientDTO clientDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
   clientServiceInterface.removeClient(clientId);
        redirectAttributes.addFlashAttribute("success", "Klient byl odstraněn");

        return "redirect:/stats";
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public String handleAlertNotFound(RedirectAttributes redirectAttributes){
    redirectAttributes.addFlashAttribute("error", "Klient nenalezen");
        return "pages/stats";
    }


}
