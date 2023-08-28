package eu.sana.EMERI.H.pojistovna.services;

import eu.sana.EMERI.H.pojistovna.models.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService{
    void registerUser(UserDTO userDTO, boolean Admin);

}
