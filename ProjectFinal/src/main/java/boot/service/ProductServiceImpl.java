package boot.service;

import boot.entity.Product;
import boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean create(Product object) {
        return false;
    }

    @Override
    public boolean update(Product object) {
        return false;
    }

    @Override
    public boolean delete(Product object) {
        return false;
    }

    @Override
    public Product findById(long productId) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getListByCategory(long categoryId) {
        return null;
    }

    @Override
    public List<Product> getListByCategoryAndLimit(long categoryId, int limit) {
        return null;
    }

    @Override
    public List<Product> getListFeatured(int limit) {
        return null;
    }

    @Override
    public List<Product> getListSale(int limit) {
        return null;
    }

    @Override
    public List<Product> getListNav(int start, int limit) {
        return null;
    }
}
