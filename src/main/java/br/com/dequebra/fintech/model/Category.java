package br.com.dequebra.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "t_category",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "un_name_category",
                        columnNames = "nm_category"
                )
        }
)
public class Category {

    @Id
    @Column(name = "id_category")
    private Long id;
    @Column(name = "nm_category", nullable = false, length = 50)
    private String name;


    public Category() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
