package com.desafio.banco.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.desafio.banco.model.Bankslip;
import com.desafio.banco.model.Status;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BankslipCustomRepository {
    
    private final EntityManager entityManager;

    public List<Bankslip> find(
        LocalDate dueDate, LocalDate paymentDate, Long totalInCents, Long fine, String customer, Status status
        ){
            String query = "select B from Bankslip B ";
            String condicao = "where";

            if (dueDate != null){
                query += condicao + " B.dueDate = :dueDate";
                condicao = " and ";
            }

            if (paymentDate != null){
                query += condicao + " B.paymentDate = :paymentDate";
                condicao = " and ";
            }

            if (totalInCents != null){
                query += condicao + " B.totalInCents = :totalInCents";
                condicao = " and ";
            }

            if (fine != null){
                query += condicao + " B.fine = :fine";
                condicao = " and ";
            }

            if (customer != null){
                query += condicao + " B.customer = :customer";
                condicao = " and ";
            }

            if (status != null){
                query += condicao + " B.status = :status";
                condicao = " and ";
            }

            var queryExec = entityManager.createQuery(query, Bankslip.class);

            if (dueDate != null){
                queryExec.setParameter("dueDate", dueDate);
            }

            if (paymentDate != null){
                queryExec.setParameter("paymentDate", paymentDate);
            }

            if (totalInCents != null){
                queryExec.setParameter("totalInCents", totalInCents);
            }

            if (fine != null){
                queryExec.setParameter("fine", fine);
            }

            if (customer != null){
                queryExec.setParameter("customer", customer);
            }

            if (status != null){
                queryExec.setParameter("status", status);
            }


            return queryExec.getResultList();
    }

}
