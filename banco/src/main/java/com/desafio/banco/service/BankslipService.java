package com.desafio.banco.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.banco.model.Bankslip;
import com.desafio.banco.model.Status;
import com.desafio.banco.model.dto.BankslipInput;
import com.desafio.banco.model.dto.BankslipOutput;
import com.desafio.banco.repository.BankslipCustomRepository;
import com.desafio.banco.repository.BankslipRepository;

@Service
public class BankslipService {
    
    
    public DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private BankslipRepository repository;

    @Autowired
    private BankslipCustomRepository repositoryCustom;

    public BankslipOutput create(BankslipInput bankslipInput){
        LocalDate due_time = LocalDate.parse(bankslipInput.getDue_date(), dateFormatter);
        
        Bankslip bankslip = Bankslip.builder()
                                    .dueDate(due_time)
                                    .paymentDate(null)
                                    .totalInCents(bankslipInput.getTotal_in_cents())
                                    .fine(0.0)
                                    .customer(bankslipInput.getCustomer())
                                    .status(Status.PENDING)
                                    .build();

        repository.save(bankslip);

        BankslipOutput bankslipOutput = BankslipOutput.builder()
                                    .due_date(due_time.format(dateFormatter))
                                    .payment_date(null)
                                    .total_in_cents(bankslipInput.getTotal_in_cents())
                                    .fine(0)
                                    .customer(bankslipInput.getCustomer())
                                    .status(Status.PENDING)
                                    .build();

        return bankslipOutput;

    }

    public Bankslip create(Bankslip bankslipInput){
        
        return repository.save(bankslipInput);

    }

    public List<Bankslip> getAll(){
        repository.findAll().forEach(bankslip -> setStatus(bankslip));
        return repository.findAll();
    }

	public List<Bankslip> findCustom(
        String dueDateString, String paymentDateString, Long totalInCents, Long fine, String customer, Status status
    ){
        LocalDate dueDate = null;
        LocalDate paymenteDate = null;
        
        if (dueDateString != null){
            dueDate = LocalDate.parse(dueDateString, dateFormatter);
        }
        
        if (paymentDateString != null){
            paymenteDate = LocalDate.parse(paymentDateString, dateFormatter);
        }

        return repositoryCustom.find(dueDate, paymenteDate, totalInCents, fine, customer, status);
    }

    public List<Bankslip> orderByDate() {
        List<Bankslip> queryBankslips = repository.findAll();
        Collections.sort(queryBankslips);
        queryBankslips.forEach(bankslip -> setStatus(bankslip));
        return queryBankslips;
    }

	public Bankslip findById(Long id) {
        Bankslip bankslip = repository.findById(id).orElse(null);
        setStatus(bankslip);
		return bankslip;
	}

    private static void setStatus(Bankslip bankslip){
        
        if (bankslip.getDueDate().isBefore(LocalDate.now())){
            bankslip.setStatus(Status.OVERDUE);
        } else if (bankslip.getPaymentDate()!=null){
            bankslip.setStatus(Status.CLOSED);
        }else{
            bankslip.setStatus(Status.PENDING);
        }
        
    }

    public Page<Bankslip> findByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
