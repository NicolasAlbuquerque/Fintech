package br.com.dequebra.fintech.service;

import br.com.dequebra.fintech.model.Income;
import br.com.dequebra.fintech.model.Transaction;
import br.com.dequebra.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Income save(Income income) {
        return transactionRepository.save(income);
    }

    public Income findIncomeById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (transaction instanceof Income income) {
            return income;
        }

        throw new RuntimeException("Transaction is not an Income");
    }

    public List<Income> findAll() {
        return transactionRepository.findAll()
                .stream()
                .filter(t -> t instanceof Income)
                .map(t -> (Income) t)
                .toList();
    }

    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (!(transaction instanceof Income)) {
            throw new RuntimeException("Transaction is not an Income");
        }

        transactionRepository.deleteById(id);
    }

    public Income update(Long id, Income incomeUpdated) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (!(transaction instanceof Income income)) {
            throw new RuntimeException("Transaction is not an Income");
        }

        income.setDate(incomeUpdated.getDate());
        income.setAmount(incomeUpdated.getAmount());
        income.setDescription(incomeUpdated.getDescription());
        income.setSource(incomeUpdated.getSource());

        return transactionRepository.save(income);
    }
}