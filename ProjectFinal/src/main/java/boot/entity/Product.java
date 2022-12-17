package boot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private int price;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;
}
