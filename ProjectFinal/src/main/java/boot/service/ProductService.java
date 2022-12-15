package boot.service;

import boot.entity.Products;

import java.util.List;

public interface ProductService {
    // create
    boolean create(Products object);

    // update
    boolean update(Products object);

    // delete
    boolean delete(Products object);

    // find by id
    Products findById(long productId);

    List<Products> getAll();
    // load list product by category
    List<Products> getListByCategory(long categoryId);

    // load list product by category and limit
    List<Products> getListByCategoryAndLimit(long categoryId, int limit);

    // load list product by featured
    List<Products> getListFeatured(int limit);

    // load list product by sale
    List<Products> getListSale(int limit);

    // load list product by nav
    List<Products> getListNav(int start, int limit);
}
