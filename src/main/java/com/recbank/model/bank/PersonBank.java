package com.kbank.model.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "person_bank", schema = "banks")
public class PersonBank {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    PersonBankKey id;

    @ManyToOne
    @MapsId("person_id")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @MapsId("bank_id")
    @JoinColumn(name = "bank_id")
    private Bank bank;

}
