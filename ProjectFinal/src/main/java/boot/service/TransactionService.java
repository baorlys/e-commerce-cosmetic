package boot.service;

import boot.entity.Transaction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    void deleteById(Long transId);

    Optional<Transaction> findById(Long transId);

    List<Transaction> findAll();

    Transaction save(Transaction trans);

    List<Transaction> findByStatusIs(int status);

    Transaction findTop();

    Transaction findByUserId(Long userId);

    void confirm(Long transId);

    void cancel(Long transId);
}
