package boot.entity;

import boot.dto.CartItem;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trans_id", nullable = false)
    private long transId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "trans_address", nullable = false)
    private String transAddress;

    @Column(name = "trans_date")
    private Date transDate;


    @Column(name ="trans_status")
    private int status;

}
