package br.com.dequebra.fintech.service;

import br.com.dequebra.fintech.model.Investment;
import br.com.dequebra.fintech.model.Transaction;
import br.com.dequebra.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Investment save(Investment investment) {
        return transactionRepository.save(investment);
    }

    public Investment findInvestmentById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (transaction instanceof Investment investment) {
            return investment;
        }

        throw new RuntimeException("Transaction is not an Investment");
    }

    public List<Investment> findAll() {
        return transactionRepository.findAll()
                .stream()
                .filter(t -> t instanceof Investment)
                .map(t -> (Investment) t)
                .toList();
    }

    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (!(transaction instanceof Investment)) {
            throw new RuntimeException("Transaction is not an Investment");
        }

        transactionRepository.deleteById(id);
    }

    public Investment update(Long id, Investment investmentUpdated) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (!(transaction instanceof Investment investment)) {
            throw new RuntimeException("Transaction is not an Investment");
        }

        investment.setDate(investmentUpdated.getDate());
        investment.setAmount(investmentUpdated.getAmount());
        investment.setDescription(investmentUpdated.getDescription());

        investment.setPayoutDate(investmentUpdated.getPayoutDate());
        investment.setInvestmentName(investmentUpdated.getInvestmentName());
        investment.setIssuingBank(investmentUpdated.getIssuingBank());
        investment.setTaxable(investmentUpdated.getTaxable());
        investment.setInterestRate(investmentUpdated.getInterestRate());

        return transactionRepository.save(investment);
    }
}