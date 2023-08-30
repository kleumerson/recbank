package com.recbank.model.bank;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonBankKey implements Serializable {

    @Column(name = "person_id")
    private int person_id;
    @Column(name = "accoount_id")
    private int account_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBankKey that = (PersonBankKey) o;
        return person_id == that.person_id && account_id == that.account_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, account_id);
    }
}
