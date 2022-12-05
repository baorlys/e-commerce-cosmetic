package boot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "brand", length = 500)
    private String brand;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "amount")
    private int amount;

    @Column(name = "description")
    private String desc;

    @Column(name = "pic")
    private String pic;
}
