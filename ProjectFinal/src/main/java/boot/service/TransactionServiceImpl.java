package boot.service;

import boot.entity.TransItem;
import boot.entity.Transaction;
import boot.repository.ProductRepository;
import boot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private TransItemService transItemService;


    @Override
    public void deleteById(Long transId) {
        transactionRepository.deleteById(transId);
    }

    @Override
    public Optional<Transaction> findById(Long transId) {
        Optional<Transaction> transaction = transactionRepository.findById(transId);
        return  transaction;
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction trans) {
        return transactionRepository.save(trans);
    }

    @Override
    public List<Transaction> findByStatusIs(int status) {
        return transactionRepository.findByStatusIs(status);
    }

    @Override
    public Transaction findTop() {
        return transactionRepository.findTop();
    }

    @Override
    public Transaction findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public void confirm(Long transId) {
        Transaction trans = transactionRepository.findById(transId).get();
        trans.setStatus(1);
        List<TransItem> transItemList = transItemService.findByTrans(trans);
        for (TransItem item : transItemList) {
            productService.updateAmount(item.getProduct().getProductId(),item.getProduct().getAmount() - item.getQuantity());
        }
        transactionRepository.save(trans);
    }

    @Override
    public void cancel(Long transId) {
        Transaction trans = transactionRepository.findById(transId).get();
        trans.setStatus(2);
        transactionRepository.save(trans);
    }


}
