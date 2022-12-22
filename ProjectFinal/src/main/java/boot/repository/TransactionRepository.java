package boot.repository;

import boot.entity.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Override
    void deleteById(Long transId);

    @Override
    Optional<Transaction> findById(Long transId);

    @Override
    List<Transaction> findAll();

    @Override
    Transaction save(Transaction trans);

    @Query(value = "select t from Transaction t where t.status = ?1")
    List<Transaction> findByStatusIs(int status);

    @Query(value = "SELECT * FROM Transaction t ORDER BY trans_id DESC LIMIT 1", nativeQuery=true)
    Transaction findTop();

    @Query(value = "SELECT t from Transaction t where t.user.userId = ?1")
    Transaction findByUserId(Long userId);
}
