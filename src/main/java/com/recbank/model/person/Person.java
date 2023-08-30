package com.recbank.model.person;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "person", schema = "banks")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "socialNumber")
    private String socialNumber;

    //@ManyToMany
   // @JoinTable(name = "person_account",
    //        joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    //private List<Account> account;
}
