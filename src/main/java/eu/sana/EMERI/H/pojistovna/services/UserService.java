package eu.sana.EMERI.H.pojistovna.services;

import eu.sana.EMERI.H.pojistovna.data.entities.UserEntity;
import eu.sana.EMERI.H.pojistovna.data.repositories.UserRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.models.UserDTO;
import eu.sana.EMERI.H.pojistovna.models.exeptions.DuplicateEmailException;
import eu.sana.EMERI.H.pojistovna.models.exeptions.PasswordsDoNotEqualException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepositoryInterface userRepositoryInterface;
    @Override
    public void registerUser(UserDTO userDTO, boolean Admin) {
if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
    throw new PasswordsDoNotEqualException();
}
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setAdmin(Admin);

        try {
            userRepositoryInterface.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepositoryInterface.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
}
