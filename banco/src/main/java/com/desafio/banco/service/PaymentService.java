package com.desafio.banco.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.banco.helper.Calculator;
import com.desafio.banco.model.Bankslip;
import com.desafio.banco.model.dto.PaymentOutput;

@Service
public class PaymentService {

    @Autowired
    private BankslipService bankslipService;

    @Autowired
    private ModelMapper mapper;

    public PaymentOutput createPayment(Long idBankslip) {

        Bankslip bankslip = bankslipService.findById(idBankslip);
        Double fine = Calculator.toCalculate(bankslip.getDueDate(), bankslip.getTotalInCents());
        PaymentOutput output = mapper.map(bankslip, PaymentOutput.class);
        output.setFine(fine);
        return output;
    }
    
}
