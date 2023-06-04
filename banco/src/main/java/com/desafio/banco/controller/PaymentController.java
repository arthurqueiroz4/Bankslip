package com.desafio.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.banco.service.PaymentService;

@RestController
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    @PostMapping
    public void payment(@RequestParam(name = "idBankslip", required = true) Long idBankslip){
        service.createPayment(idBankslip);
    }
}
