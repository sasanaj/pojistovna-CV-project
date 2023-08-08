package eu.sana.EMERI.H.pojistovna.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientDTO {
    private long clientId;
    @NotNull(message = "povinny udaj")
    @NotBlank(message = "povinny udaj")
    private String jmeno;
    @NotNull(message = "povinny udaj")
    @NotBlank(message = "povinny udaj")
    private String prijmeni;
    @NotNull(message = "povinny udaj")
    @Size(min = 9, max = 12, message = "zadejte platne telefoni cislo")
    @NotBlank(message = "povinny udaj")
    private String telefon;
    @NotNull(message = "povinny udaj")
    @NotBlank(message = "povinny udaj")
    @Email(message = "zadejte platnou emailovou adresu")
    private String email;





    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
