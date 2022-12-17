package boot.service;

import boot.dto.CartItem;

import java.util.Collection;

public interface CartService {
    void add(CartItem item);
    void remove(int productId);
    void clear();
    Collection<CartItem> getCartItems();

    void update(int productId, int quantity);

    public int getTotalPrice();

    public int getCount();
}
