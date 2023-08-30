package com.recbank.service.branch;

import com.recbank.dto.branch.BranchDto;
import com.recbank.model.branch.Branch;
import com.recbank.repository.branch.BranchRegisterRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchRegisterService {

    @Autowired
    BranchRegisterRepository branchRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public BranchDto saveBranch(BranchDto branchDto){
        Branch branch = modelMapper.map(branchDto, Branch.class);
        if (!existBranchCode(branchDto.getCode()))
            branchRepository.save(branch);
        else
            System.out.println("Code already exists, please enter another branch code.");
        return modelMapper
                .map(branch, BranchDto.class);
    }

    public boolean existBranchCode(int code){
        Optional<Branch> optionalCode = branchRepository.findById(code);
        return optionalCode.isPresent();
    }
}
