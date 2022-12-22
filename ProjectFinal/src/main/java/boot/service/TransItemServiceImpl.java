package boot.service;

import boot.entity.TransItem;
import boot.entity.Transaction;
import boot.repository.TransItemRepository;
import boot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransItemServiceImpl implements TransItemService{
    @Autowired
    TransItemRepository transItemRepository;


    @Override
    public void deleteById(Long transItemId) {
        transItemRepository.deleteById(transItemId);
    }

    @Override
    public Optional<TransItem> findById(Long transItemId) {
        return transItemRepository.findById(transItemId);
    }

    @Override
    public List<TransItem> findAll() {
        return transItemRepository.findAll();
    }

    @Override
    public TransItem save(TransItem transItem) {
        return transItemRepository.save(transItem);
    }

    @Override
    public List<TransItem> findByTrans(Transaction transaction) {
        return transItemRepository.findByTrans(transaction);
    }


}
