package service;

import boot.entity.Product;
import boot.repository.*;
import boot.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void whenGetAll_shouldReturnList() {
        List<Product> mockProducts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mockProducts.add(new Product());
        }
        // 2. define behavior of Repository
        when(productRepository.findAll()).thenReturn(mockProducts);

        // 3. call service method
        List<Product> actualProduct = productService.getAll();

        // 4. assert the result
        assertThat(actualProduct.size()).isEqualTo(mockProducts.size());

        // 4.1 ensure repository is called
        verify(productRepository).findAll();
    }

    @Test
    public void whenCreate_shouldReturnTrue() {
        Product mockProduct = new Product();
        mockProduct.setAmount(10);
        mockProduct.setDesc("desc");
        mockProduct.setPrice(100);
        // 2. define behavior of Repository
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);

        // 3. call service method
        boolean actualResult = productService.create(mockProduct);

        // 4. assert the result
        assertThat(actualResult).isTrue();

        // 4.1 ensure repository is called
        verify(productRepository).save(any(Product.class));
    }

    @Test
    public void whenDelete_shouldReturnTrue() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        mockProduct.setAmount(10);
        mockProduct.setDesc("desc");
        mockProduct.setPrice(100);

        // 2. Define behavior of Repository
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(mockProduct)); // Simulate existing product

        // 3. Call service method
        boolean actualResult = productService.delete(mockProduct);

        // 4. Assert the result
        assertThat(actualResult).isTrue();

        // 4.1 Ensure repository is called
        verify(productRepository).delete(mockProduct);
    }

    @Test
    public void whenDeleteById_shouldReturnTrue() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        mockProduct.setAmount(10);
        mockProduct.setDesc("desc");
        mockProduct.setPrice(100);
        // 2. define behavior of Repository
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(mockProduct)); // Simulate existing product

        // 3. call service method
        boolean actualResult = productService.deleteById(1);

        // 4. assert the result
        assertThat(actualResult).isTrue();

        // 4.1 ensure repository is called
        verify(productRepository).deleteById(1L);
    }


    @Test
    public void whenUpdate_shouldReturnTrue() {
        // 1. Mock product update
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        mockProduct.setAmount(20);
        mockProduct.setDesc("desc");
        mockProduct.setPrice(200);
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(new Product())); // Simulate existing product
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);

        // 2. Call the service method
        boolean actualResult = productService.update(1, mockProduct);

        // 3. Assert the result
        assertThat(actualResult).isTrue();

        // 4. Verify repository calls
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(any(Product.class)); // Expect save to be called once
    }

    @Test
    public void whenFindById_shouldReturnProduct() {
        Product mockProduct = new Product();
        mockProduct.setAmount(10);
        mockProduct.setDesc("desc");
        mockProduct.setPrice(100);
        // 2. define behavior of Repository
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(mockProduct));

        // 3. call service method
        Product actualResult = productService.findById(1L).get();

        // 4. assert the result
        assertThat(actualResult).isEqualTo(mockProduct);

        // 4.1 ensure repository is called
        verify(productRepository).findById(1L);
    }

    @Test
    public void whenUpdateAmount_shouldReturnTrue() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        mockProduct.setAmount(20);
        mockProduct.setDesc("desc");
        mockProduct.setPrice(200);
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(new Product())); // Simulate existing product
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);

        // 3. call service method
        boolean actualResult = productService.updateAmount(1, 10);

        // 4. assert the result
        assertThat(actualResult).isTrue();

        // 4.1 ensure repository is called
        verify(productRepository).save(any(Product.class));
    }


}
