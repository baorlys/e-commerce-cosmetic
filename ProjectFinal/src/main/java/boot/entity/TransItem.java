package boot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "trans_item")
public class TransItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trans_item_id", nullable = false)
    private long transItemId;

    @ManyToOne
    @JoinColumn(name ="trans_id")
    private Transaction transaction;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

}
