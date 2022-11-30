package boot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "amount")
    private int amount;

    @Column(name = "desc")
    private String desc;

    @Column(name = "pic")
    private String pic;
}
