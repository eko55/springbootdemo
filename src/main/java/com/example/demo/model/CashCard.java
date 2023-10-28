package com.example.demo.model;

import org.springframework.data.annotation.Id;

/**
 * Entity class , represent entry in the DB.Data fields represent columns in a db table.
 */
public class CashCard {

    @Id //tell Spring Data that this is the id to use in the Repository impl
    private Long id;

    private Double amount;

    public CashCard() {
    }

    public CashCard(Long id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
