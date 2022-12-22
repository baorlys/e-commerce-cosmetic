package boot.repository;

import boot.entity.TransItem;
import boot.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransItemRepository  extends JpaRepository<TransItem, Long> {
    @Override
    void deleteById(Long transItemId);

    @Override
    Optional<TransItem> findById(Long transItemId);

    @Override
    List<TransItem> findAll();

    @Override
    TransItem save(TransItem transItem);


    @Query(value = "select ti from TransItem ti where ti.transaction = ?1")
    List<TransItem> findByTrans(Transaction transaction);

}