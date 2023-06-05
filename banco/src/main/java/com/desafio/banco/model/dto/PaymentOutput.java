package com.desafio.banco.model.dto;

import java.time.LocalDate;

import com.desafio.banco.model.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOutput {
    
    private LocalDate dueDate;
	private LocalDate paymentDate;

    private long totalInCents;
	private Double fine;

    private String customer;

    private Status status;

}
