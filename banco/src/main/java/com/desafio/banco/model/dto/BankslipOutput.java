package com.desafio.banco.model.dto;

import com.desafio.banco.model.Status;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankslipOutput {
    
    private String due_date;
	private String payment_date;

    private long total_in_cents;
	private long fine;

    private String customer;

    private Status status;
}
