package com.desafio.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.banco.model.dto.PaymentOutput;
import com.desafio.banco.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    @GetMapping
    public PaymentOutput payment(@RequestParam(name = "idBankslip", required = true) Long idBankslip){
        return service.createPayment(idBankslip);
    }

    @PostMapping
    public PaymentOutput toPay(@RequestParam(name = "idBankslip", required = true) Long idBankslip,
                               @RequestParam(name = "valueToPay", required = true) Double toPay){
        return service.toPay(idBankslip, toPay);
    }
}
