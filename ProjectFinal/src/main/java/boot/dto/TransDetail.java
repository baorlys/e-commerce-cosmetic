package boot.dto;

import boot.entity.TransItem;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TransDetail {
    private Long id;
    private String username;
    private int totalPrice;
    private Date date;
    private List<TransItem> transItemList;
}
