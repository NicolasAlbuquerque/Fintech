package br.com.dequebra.fintech.service;

import br.com.dequebra.fintech.model.Goal;
import br.com.dequebra.fintech.model.Transaction;
import br.com.dequebra.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Goal save(Goal transaction){ return transactionRepository.save(transaction); }

    public Goal findGoalById(Long id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if(transaction instanceof Goal goal){
            return goal;
        }

        throw new RuntimeException("Transaction is not a Goal");
    }

    public List<Goal> findAll(){

        return  transactionRepository.findAll()
                .stream()
                .filter(t -> t instanceof Goal)
                .map(t -> (Goal) t)
                .toList();
    }

    public void delete(Long id){
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found."));
        if(!(transaction instanceof Goal)){
            throw  new RuntimeException("Transaction is not a Goal");

        }
        transactionRepository.deleteById(id);

    }

    public Goal update(Long id, Goal goalUpdated){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        if(!(transaction instanceof Goal goal)){
            throw new RuntimeException("Transaction is not a Goal");
        }


        goal.setDate(goalUpdated.getDate());
        goal.setAmount(goalUpdated.getAmount());
        goal.setDescription(goalUpdated.getDescription());

        goal.setStipulatedAmount(goalUpdated.getStipulatedAmount());
        goal.setCurrentValue(goalUpdated.getCurrentValue());
        goal.setEndDate(goalUpdated.getEndDate());

        return  transactionRepository.save(goal);
    }
}
