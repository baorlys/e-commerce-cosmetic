package boot.dto;

import boot.entity.Product;
import lombok.Data;

@Data
public class CartItem {
    private Product product;
    private int quantity;
    private int price;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public int getPrice() {
        return this.product.getPrice() * this.quantity;
    }
}
