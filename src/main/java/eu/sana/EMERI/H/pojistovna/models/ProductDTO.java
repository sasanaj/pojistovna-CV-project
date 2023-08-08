package eu.sana.EMERI.H.pojistovna.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {
    private long id;
    @NotNull(message = "povinné pole")
    @NotBlank
    private String name;
    @NotNull(message = "povinné pole")
    @NotBlank
    private String description;
    @NotNull(message = "povinné pole")
    private long price;

    private boolean daily;
    private boolean monthly;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setPrice(long price) {
        this.price = price;
    }



}
