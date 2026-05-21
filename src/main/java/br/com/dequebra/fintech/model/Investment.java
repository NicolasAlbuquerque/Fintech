package br.com.dequebra.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_investment")
@PrimaryKeyJoinColumn(name = "id_transaction")
public class Investment extends Transaction {

    @Column(name = "payout_date")
    private LocalDate payoutDate;

    @Column(name = "investment_name", nullable = false, length = 50)
    private String investmentName;

    @Column(name = "issuing_bank", nullable = false, length = 50)
    private String issuingBank;

    @Column(name = "taxable", nullable = false, length = 1)
    private String taxable;

    @Column(name = "interest_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal interestRate;

    public Investment() {
        super();
    }

    public Investment(User user, Category category, LocalDate date, BigDecimal amount, String description,
                      LocalDate payoutDate, String investmentName, String issuingBank,
                      String taxable, BigDecimal interestRate) {
        super(user, category, date, amount, description);
        this.payoutDate = payoutDate;
        this.investmentName = investmentName;
        this.issuingBank = issuingBank;
        this.taxable = taxable;
        this.interestRate = interestRate;
    }

    public LocalDate getPayoutDate() {
        return payoutDate;
    }

    public void setPayoutDate(LocalDate payoutDate) {
        this.payoutDate = payoutDate;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}