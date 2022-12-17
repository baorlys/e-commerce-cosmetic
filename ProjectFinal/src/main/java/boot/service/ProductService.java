package boot.service;

import boot.entity.Product;

import java.util.List;

public interface ProductService {
    // create
    boolean create(Product object);

    // update
    boolean update(Product object);

    // delete
    boolean delete(Product object);

    // find by id
    Product findById(long productId);

    List<Product> getAll();
    // load list product by category
    List<Product> getListByCategory(long categoryId);

    // load list product by category and limit
    List<Product> getListByCategoryAndLimit(long categoryId, int limit);

    // load list product by featured
    List<Product> getListFeatured(int limit);

    // load list product by sale
    List<Product> getListSale(int limit);

    // load list product by nav
    List<Product> getListNav(int start, int limit);
}
