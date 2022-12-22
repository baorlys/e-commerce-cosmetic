package boot.service;

import boot.dto.CartItem;

import java.util.Collection;

public interface CartService {
    void add(CartItem item);
    void remove(long productId);
    void clear();
    Collection<CartItem> getCartItems();

    void update(long productId, int quantity);

    public int getTotalPrice();

    public int getCount();
}
