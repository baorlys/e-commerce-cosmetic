package boot.repository;

import boot.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    @Override
    Optional<Products> findById(Long id);


    @Override
    void delete(Products product);

    @Override
    List<Products> findAll();
}