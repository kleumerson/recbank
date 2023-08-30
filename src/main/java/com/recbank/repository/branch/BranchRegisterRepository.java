package com.kbank.repository.branch;

import com.kbank.model.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRegisterRepository extends JpaRepository<Branch, Integer> {
}
