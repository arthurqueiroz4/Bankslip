package com.desafio.banco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.banco.model.Bankslip;
import com.desafio.banco.model.dto.BankslipInput;
import com.desafio.banco.model.dto.BankslipOutput;
import com.desafio.banco.service.BankslipService;

@RestController
@RequestMapping("/api/bankslip")
public class BankslipController {

    @Autowired
    private BankslipService service;
    
    @PostMapping
    public ResponseEntity<BankslipOutput> create( @Valid @RequestBody BankslipInput bankslipInput){
        
        
        return new ResponseEntity<BankslipOutput>(service.create(bankslipInput), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Bankslip>> getAllEntity (){
        return new ResponseEntity<List<Bankslip>>(service.getAll(), HttpStatus.OK);
    }
}
