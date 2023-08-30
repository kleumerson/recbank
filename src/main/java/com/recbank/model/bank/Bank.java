package com.kbank.model.bank;

import com.kbank.model.branch.Branch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Bank", schema = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bankName")
    private String bankName;

    @Column(name = "webAddress")
    private String webAddress;

    @Column(name = "headQuarters")
    private String headQuarters;

    @JsonIgnore
    @OneToMany(targetEntity = Branch.class, mappedBy = "bank", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Branch> branch;

}
