package boot.service;

import boot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    // create
    boolean create(Product product);
    // update
    boolean update(long productId, Product product);
    // delete
    boolean delete(Product object);
    // find by id
    Optional<Product> findById(long productId);

    List<Product> getAll();

    boolean updateAmount(long productId, int quantity);

}
