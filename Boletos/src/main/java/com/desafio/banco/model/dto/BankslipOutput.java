package com.desafio.banco.model.dto;

import java.time.LocalDate;

import com.desafio.banco.model.Status;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankslipOutput {
    
    private LocalDate due_date;
	private LocalDate payment_date;

    private long total_in_cents;
	private long fine;

    private String customer;

    private Status status;
}
