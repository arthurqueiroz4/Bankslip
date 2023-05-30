package com.desafio.banco.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.desafio.banco.model.Status;
import com.desafio.banco.model.dto.BankslipInput;
import com.desafio.banco.model.dto.BankslipOutput;

@Service
public class BankslipService {
    
    public BankslipOutput create(BankslipInput bankslipInput){

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate due_time = LocalDate.parse(bankslipInput.getDue_date(), dateFormatter);

        BankslipOutput bankslipOutput = BankslipOutput.builder()
                                    .due_date(due_time)
                                    .payment_date(null)
                                    .total_in_cents(bankslipInput.getTotal_in_cents())
                                    .fine(0)
                                    .customer(bankslipInput.getCustomer())
                                    .status(Status.PENDING)
                                    .build();

        return bankslipOutput;
    }
}
