package eu.sana.EMERI.H.pojistovna.data.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @Column(nullable = false)
    @JoinTable(name = "clients", joinColumns = @JoinColumn(name = "clientId"))
    private String clientId;
    @Column(nullable = false)
    private String orderDate;
    @Column(nullable = false)
    @JoinTable(name = "products", joinColumns = @JoinColumn(name = "productId"))
    private String productId;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column(nullable = false)
    private String price;


}
