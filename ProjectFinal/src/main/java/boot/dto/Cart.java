package boot.dto;

import boot.entity.Products;
import lombok.Data;

@Data
public class Cart {
    private Products product;
    private int quantity;
}
