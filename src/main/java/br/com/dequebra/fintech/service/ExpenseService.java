package br.com.dequebra.fintech.service;

import br.com.dequebra.fintech.model.Expense;
import br.com.dequebra.fintech.model.Transaction;
import br.com.dequebra.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Expense save(Expense transaction){
        return transactionRepository.save(transaction);
    }

    public Expense findExpenseById(Long id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if(transaction instanceof Expense expense){
            return expense;
        }

        throw new RuntimeException("Transaction is not an Expense");
    }

    public List<Expense> findAll(){

        return  transactionRepository.findAll()
                .stream()
                .filter(t -> t instanceof Expense)
                .map(t -> (Expense) t)
                .toList();
    }


    public void delete(Long id){
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found."));
        if(!(transaction instanceof Expense)){
            throw  new RuntimeException("Transaction is not an Expense");

        }
        transactionRepository.deleteById(id);

    }

    public Expense update(Long id, Expense expenseUpdated){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        if(!(transaction instanceof Expense expense)){
            throw new RuntimeException("Transaction is not an Expense");
        }


        expense.setDate(expenseUpdated.getDate());
        expense.setAmount(expenseUpdated.getAmount());
        expense.setDescription(expenseUpdated.getDescription());

        expense.setPaymentMethod(expenseUpdated.getPaymentMethod());
        expense.setPaid(expenseUpdated.isPaid());
        expense.setRecurringPayment(expenseUpdated.isRecurringPayment());

        return  transactionRepository.save(expense);
    }

}
