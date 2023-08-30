package com.kbank.model.bank;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Person", schema = "banks")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "socialNumber")
    private String socialNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "person_account",
            joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> account;

}


