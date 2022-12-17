package boot.dto;

import boot.entity.Product;
import lombok.Data;

@Data
public class Cart {
    private Product product;
    private int quantity;
}
