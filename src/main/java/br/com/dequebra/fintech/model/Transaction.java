package br.com.dequebra.fintech.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "t_transaction")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TRANSACTION"
    )
    @SequenceGenerator(
            name = "SEQ_TRANSACTION",
            sequenceName = "SEQ_TRANSACTION",
            allocationSize = 1
    )
    @Column(name = "id_transaction", nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_user",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_id_user")
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_category",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_id_category")
    )
    private Category category;

    @Column(name = "dt_transaction", nullable = false)
    private LocalDate date;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;



    @Column(name = "ds_transaction")
    private String description;


    public Transaction(){}


    public Transaction(User user, Category category, LocalDate date, BigDecimal amount, String description) {
        this.user = user;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
