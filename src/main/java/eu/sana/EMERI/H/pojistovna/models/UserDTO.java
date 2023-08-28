package eu.sana.EMERI.H.pojistovna.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
    @Email(message = "vyplnte platnou adresu")
    @NotBlank(message = "vyplnte email")
    @NotBlank(message = "vyplnte emaial")
    private String email;
    @NotBlank(message = "vyplnte heslo")
    @Size(min = 6, message = "heslo musi mit alespon 6 znaku")
    @NotNull(message = "vyplnte heslo")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotBlank(message = "zopakujte heslo heslo")
    @NotNull(message = "zopakujte heslo")
    private String confirmPassword;
}
