package br.com.dequebra.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_income")
@PrimaryKeyJoinColumn(name = "id_transaction")
public class Income extends Transaction {

    @Column(name = "source", nullable = false, length = 50)
    private String source;

    public Income() {
        super();
    }

    public Income(User user, Category category, LocalDate date, BigDecimal amount, String description, String source) {
        super(user, category, date, amount, description);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}