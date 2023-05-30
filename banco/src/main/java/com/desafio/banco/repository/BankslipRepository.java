package com.desafio.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.banco.model.Bankslip;


public interface BankslipRepository extends JpaRepository<Bankslip, Long>{
    
}
