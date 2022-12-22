package boot.service;

import boot.entity.TransItem;
import boot.entity.Transaction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransItemService {
    void deleteById(Long transItemId);

    Optional<TransItem> findById(Long transItemId);

    List<TransItem> findAll();

    TransItem save(TransItem transItem);


    @Query(value = "select ti from TransItem ti where ti.transaction = ?1")
    List<TransItem> findByTrans(Transaction transaction);

}
