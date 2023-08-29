package eu.sana.EMERI.H.pojistovna.controller;

import eu.sana.EMERI.H.pojistovna.data.repositories.UserRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.models.UserDTO;
import eu.sana.EMERI.H.pojistovna.models.exeptions.DuplicateEmailException;
import eu.sana.EMERI.H.pojistovna.models.exeptions.PasswordsDoNotEqualException;
import eu.sana.EMERI.H.pojistovna.services.UserServiceInterface;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @GetMapping("/login")
    public String renderLogin(UserDTO userDTO){
        return "pages/account/login";
    }
    @GetMapping("/register")
    public String renderRegister(UserDTO userDTO){
       return "pages/account/register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDTO userDTO, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "chybně vyplněný formulář");
            return renderRegister(userDTO);
        }
        try {
            userServiceInterface.registerUser(userDTO, false);
        } catch (DuplicateEmailException e) {
            result.rejectValue("email", "error", "Email je již používán.");
            return "/pages/account/register";
        } catch (PasswordsDoNotEqualException e) {
            result.rejectValue("password", "error", "Hesla se nerovnají.");
            result.rejectValue("confirmPassword", "error", "Hesla se nerovnají.");
            return "/pages/account/register";
        }

        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
        return "redirect:/account/login";
    }
    @GetMapping("/logout")
    public String logout(){
           return "redirect:/account/login";

    }

}
