package com.daklan.budget.control.rest.pojotest.mainpojotestclasses;

import com.google.code.beanmatchers.ValueGenerator;

import java.time.LocalDate;
import java.util.Random;

public class LocalDateValueGenerator implements ValueGenerator<LocalDate> {

    private final Random random = new Random();

    @Override
    public LocalDate generate() {
        int year = random.nextInt(180) + 1920;
        int month = random.nextInt(11) + 1;
        int dayOfMonth = random.nextInt(27) + 1;

        return LocalDate.of(year, month, dayOfMonth);
    }
}
