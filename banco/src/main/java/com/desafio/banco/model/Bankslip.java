package com.desafio.banco.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bankslip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "due_date field is required")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate due_date;
	private LocalDate payment_date;

    @NotNull(message = "total_in_cents field is required")
    private long total_in_cents;
	private long fine;


    private String customer;

    @Enumerated(EnumType.STRING)
    private Status status;
}
