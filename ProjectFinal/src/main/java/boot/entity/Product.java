package boot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id",nullable = false, length = 11)
    private long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "amount", columnDefinition = "int default 0", length = 11)
    private int amount;

    @Column(name = "desc")
    private String desc;

    @Column(name = "pic")
    private String pic;
}
