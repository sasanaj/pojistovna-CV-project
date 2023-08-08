package eu.sana.EMERI.H.pojistovna.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    @Column(nullable = false)
    private String jmeno;
    @Column(nullable = false)
    private String prijmeni;
    @Column(nullable = false)
    private String telefon;
    @Column(nullable = false)
    private String email;

    /**
     * get field @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

      *
      * @return clientId @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     */
    public long getClientId() {
        return this.clientId;
    }

    /**
     * set field @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

      *
      * @param clientId @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     */
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    /**
     * get field @Column(nullable = false)
     *
     * @return jmeno @Column(nullable = false)

     */
    public String getJmeno() {
        return this.jmeno;
    }

    /**
     * set field @Column(nullable = false)
     *
     * @param jmeno @Column(nullable = false)

     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * get field @Column(nullable = false)
     *
     * @return prijmeni @Column(nullable = false)

     */
    public String getPrijmeni() {
        return this.prijmeni;
    }

    /**
     * set field @Column(nullable = false)
     *
     * @param prijmeni @Column(nullable = false)

     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * get field @Column(nullable = false)
     *
     * @return telefon @Column(nullable = false)

     */
    public String getTelefon() {
        return this.telefon;
    }

    /**
     * set field @Column(nullable = false)
     *
     * @param telefon @Column(nullable = false)

     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * get field @Column(nullable = false)
     *
     * @return email @Column(nullable = false)

     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set field @Column(nullable = false)
     *
     * @param email @Column(nullable = false)

     */
    public void setEmail(String email) {
        this.email = email;
    }
}
