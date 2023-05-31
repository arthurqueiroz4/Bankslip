package com.desafio.banco.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.banco.model.Bankslip;
import com.desafio.banco.model.Status;
import com.desafio.banco.model.dto.BankslipInput;
import com.desafio.banco.model.dto.BankslipOutput;
import com.desafio.banco.service.BankslipService;

@RestController
@RequestMapping("/api/bankslip")
public class BankslipController {

    @Autowired
    private BankslipService service;
    
    private boolean existsInListEntities;

    @PostMapping
    public ResponseEntity<BankslipOutput> create( @Valid @RequestBody BankslipInput bankslipInput){
        
        
        return new ResponseEntity<BankslipOutput>(service.create(bankslipInput), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Bankslip>> getAllEntity (){
        return new ResponseEntity<List<Bankslip>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Bankslip>> getFilterEntity(
        @RequestParam(name = "due_date", required = false) Optional<String> due_date_String,
        @RequestParam(name = "payment_date", required = false) Optional<String> payment_date_String,
        @RequestParam(name ="total_in_cents", required = false) Optional<Long> total_in_cents,
        @RequestParam(name ="fine", required = false) Optional<Long> fine,
        @RequestParam(name ="customer", required = false) Optional<String> customer,
        @RequestParam(name ="status", required = false) Optional<Status> status
    ){
        

        List<Bankslip> listReturn = service.findCustom(
            due_date_String.orElse(null), payment_date_String.orElse(null), total_in_cents.orElse(null),
            fine.orElse(null), customer.orElse(null), status.orElse(null)
            );

        return new ResponseEntity<List<Bankslip>>(listReturn, HttpStatus.OK);
    }
}
