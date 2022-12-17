package boot.entity;

import boot.dto.CartItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trans_id", nullable = false)
    private long transId;

    @Column(name = "trans_address", nullable = false)
    private String transAddress;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="trans_item_id")
    private List<TransItem> cartItems;

    @Column(name ="trans_status")
    private int status;
}
