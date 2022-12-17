package boot.service;

import boot.dto.CartItem;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{

    private Map<Long, CartItem> map = new HashMap<Long,CartItem>();

    @Override
    public void add(CartItem item) {
        CartItem existedItem = map.get(item.getProduct().getProductId());
        if (existedItem != null) {
            existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
        } else {
            map.put(item.getProduct().getProductId(), item);
        }
    }

    @Override
    public void remove(int productId) {
        map.remove(productId);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<CartItem> getCartItems() {
        return map.values();
    }

    @Override
    public void update(int productId, int quantity) {
        CartItem item = map.get(productId);
        item.setQuantity(item.getQuantity() + quantity);
        if (item.getQuantity() <= 0) {
            map.remove(productId);
        }
    }

    @Override
    public int getTotalPrice() {
        return map.values().stream().mapToInt(item -> item.getQuantity() * item.getProduct().getPrice()).sum();
    }

    @Override
    public int getCount() {
        return map.values().size();
    }
}
