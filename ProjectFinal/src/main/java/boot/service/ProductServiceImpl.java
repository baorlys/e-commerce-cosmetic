package boot.service;

import boot.entity.Products;
import boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean create(Products object) {
        return false;
    }

    @Override
    public boolean update(Products object) {
        return false;
    }

    @Override
    public boolean delete(Products object) {
        return false;
    }

    @Override
    public Products findById(long productId) {
        return null;
    }

    @Override
    public List<Products> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Products> getListByCategory(long categoryId) {
        return null;
    }

    @Override
    public List<Products> getListByCategoryAndLimit(long categoryId, int limit) {
        return null;
    }

    @Override
    public List<Products> getListFeatured(int limit) {
        return null;
    }

    @Override
    public List<Products> getListSale(int limit) {
        return null;
    }

    @Override
    public List<Products> getListNav(int start, int limit) {
        return null;
    }
}
