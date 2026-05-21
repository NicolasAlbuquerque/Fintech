package br.com.dequebra.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_goal")
@PrimaryKeyJoinColumn(name = "id_transaction")
public class Goal extends Transaction {

    @Column(name = "stipulatedamount", nullable = false)
    private BigDecimal stipulatedAmount;

    @Column(name = "currentvalue", nullable = false)
    private BigDecimal currentValue;

    @Column(name = "enddate", nullable = false)
    private LocalDate endDate;

    public Goal(){
        super();
    }

    public Goal(User user, Category category, LocalDate date, BigDecimal amount, String description, BigDecimal stipulatedAmount, BigDecimal currentValue, LocalDate endDate){
        super(user, category, date, amount, description);
        this.stipulatedAmount = stipulatedAmount;
        this.currentValue = currentValue;
        this.endDate = endDate;
    }

    public BigDecimal getStipulatedAmount() { return stipulatedAmount; }

    public void setStipulatedAmount(BigDecimal stipulatedAmount){ this.stipulatedAmount = stipulatedAmount; }

    public BigDecimal getCurrentValue() { return  currentValue; }

    public void setCurrentValue(BigDecimal currentValue){ this.currentValue = currentValue; }

    public LocalDate getEndDate() { return endDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

}
