package com.desafio.banco.model.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BankslipInput {

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "due_date field is required")
    private String due_date;
    @NotNull(message = "customer field is required")
    private String customer;

    @NotNull(message = "total_in_cents field is required")
    private long total_in_cents;
}
