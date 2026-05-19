package br.com.dequebra.fintech.repository;

import br.com.dequebra.fintech.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
