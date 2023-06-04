package com.desafio.banco.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.banco.model.Bankslip;


public interface BankslipRepository extends JpaRepository<Bankslip, Long>{

    //@Query("select from Bankslip b where b.due_date = :due_date")
    List<Bankslip> findBydueDate(LocalDate due_date);

    List<Bankslip> findByPaymentDate(LocalDate paymentDate);

    List<Bankslip> findByTotalInCents(Long total_in_cents);
    
}
