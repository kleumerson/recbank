package com.recbank.repository.bank;

import com.recbank.model.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRegisterRepository extends JpaRepository<Bank,Integer>, JpaSpecificationExecutor<Bank> {
    @Query("select b from Bank b JOIN b.branch where b.id=:id")
    public List<Bank> findByBankAndBranch(@Param("id") int id);
    Optional<Bank> findByBankName(String bankName);
}
