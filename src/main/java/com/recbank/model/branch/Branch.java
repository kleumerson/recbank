package com.kbank.model.branch;

import com.kbank.model.bank.Bank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "Branch",schema = "banks")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @ManyToOne (targetEntity = Bank.class)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id == branch.id && code == branch.code && Objects.equals(name, branch.name) && Objects.equals(address, branch.address) && Objects.equals(phone, branch.phone) && Objects.equals(bank, branch.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, address, phone, bank);
    }
}
