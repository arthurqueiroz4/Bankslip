package com.desafio.banco.helper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    private static LocalDate now = LocalDate.now();

    public static Double toCalculate(LocalDate dueDate, Long totalInCents){
        Long daysToFine = ChronoUnit.DAYS.between(dueDate, now);
        if (daysToFine >= 10){
            return isAfterNow(totalInCents, daysToFine);
        } else {
            return isBeforeNow(totalInCents, daysToFine);
        }
    }

    public static Double isBeforeNow(Long totalInCents, Long daysToFine) {
        Double tax = 0.005 * daysToFine;
        Double total = totalInCents * tax;
        return total;
    }

    public static Double isAfterNow(Long totalInCents, Long daysToFine) {
        Double tax = 0.01 * daysToFine;
        Double total = totalInCents * tax;
        return total;
    }




}
