package com.kbank.controller.branch;

import com.kbank.dto.branch.BranchDto;
import com.kbank.service.branch.BranchRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/")
public class BranchRegisterController {
    @Autowired
    BranchRegisterService branchRegisterService;
    @PostMapping(path = "branch")
    public ResponseEntity<BranchDto> saveBranch(@RequestBody BranchDto branchDto){
        BranchDto createBranchDto = branchRegisterService.saveBranch(branchDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createBranchDto);
    }
}
