package boot.service;

import boot.entity.Product;
import boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public boolean create(Product product) {
        productRepository.save(product);
        return true;
    }
    @Override
    public boolean delete(Product product) {
        productRepository.delete(product);
        return true;
    }

    @Override
    public boolean update(long productId, Product productUpdate) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            Product _product = product.get();
            _product.setAmount(productUpdate.getAmount());
            _product.setDesc(productUpdate.getDesc());
            _product.setPrice(productUpdate.getPrice());
            productRepository.save(_product);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Product> findById(long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean updateAmount(long productId, int quantity) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            Product _product = product.get();
            _product.setAmount(quantity);
            productRepository.save(_product);
            return true;
        }
        return false;
    }

}
