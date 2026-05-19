package br.com.dequebra.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_expense")
@PrimaryKeyJoinColumn(name = "id_transaction")
public class Expense extends Transaction {

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "payment_status", nullable = false)
    private boolean paid;

    @Column(name = "recurring_payment", nullable = false)
    private boolean recurringPayment;

    public Expense(){
        super();
    }

    public Expense(User user, Category category, LocalDate date, BigDecimal amount, String description, String paymentMethod, boolean paid, boolean recurringPayment) {
        super(user, category, date, amount, description);
        this.paymentMethod = paymentMethod;
        this.paid = paid;
        this.recurringPayment = recurringPayment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paymentStatus) {
        this.paid = paymentStatus;
    }

    public boolean isRecurringPayment() {
        return recurringPayment;
    }

    public void setRecurringPayment(boolean recurringPayment) {
        this.recurringPayment = recurringPayment;
    }
}
