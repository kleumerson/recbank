package com.kbank.specification;

import com.kbank.model.bank.Bank;
import org.springframework.data.jpa.domain.Specification;

public class BankSpecification {
    public static Specification<Bank> nome(String nome){
        return (((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("nome"), nome)));
    }
    public static Specification<Bank> headQuarters(String nome){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("headQuarters"), "%" +  nome + "%");
    }
}
