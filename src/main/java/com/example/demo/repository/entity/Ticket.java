package com.example.demo.repository.entity;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket extends BaseEntity{
    @Column(nullable = false, length = 255)
    private String action;

    @Column(nullable = false, length = 255)
    private String object;

    @Column(nullable=false,length = 255)
    private String details;

    @Column(nullable = false, length = 255)
    private String status;

    @ManyToOne
    private User user;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
