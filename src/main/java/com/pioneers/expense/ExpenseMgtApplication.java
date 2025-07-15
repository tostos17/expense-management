package com.pioneers.expense;

import com.pioneers.expense.dto.ExpenseDto;
import com.pioneers.expense.service.ExpenseService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ExpenseMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseMgtApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ExpenseService expenseService) {
		return arg -> {
			expenseService.saveExpense(new ExpenseDto("table", "big beautiful table", LocalDate.now().toString(), 5, new BigDecimal(7.50)));
		};
	}
}
