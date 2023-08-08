package eu.sana.EMERI.H.pojistovna.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @Column(nullable = false)
 private    String name;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
   private long price;

    @Column(nullable = true)
    private boolean daily;
    @Column(nullable = true)
    private boolean monthly;

    public long getId() {
        return id;
    }
   /* public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
*/
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public boolean isDaily() {
        return daily;
    }

    public void setDaily(boolean daily) {
        this.daily = daily;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
