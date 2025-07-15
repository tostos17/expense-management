package com.pioneers.expense.service;

import com.pioneers.expense.dto.ExpenseDto;
import com.pioneers.expense.model.Expense;
import com.pioneers.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(ExpenseDto expenseDto) {

        return expenseRepository.save(convertToExpense(expenseDto));
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

//    public List<Expense> getExpensesForMonth(String month) {
//        expenseRepository.getExpensesForMonth()
//    }

    public Expense getExpenseById(long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        return optionalExpense.isPresent() ? optionalExpense.get() : null;
    }

    private Expense convertToExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setCost(expenseDto.getCost());
        expense.setDescription(expenseDto.getDescription());
        expense.setQuantity(expenseDto.getQuantity());
        expense.setProductName(expenseDto.getProductName());
        expense.setTransactionDate(expenseDto.getTransactionDate() == null ||
                expenseDto.getTransactionDate().equalsIgnoreCase("") ?
                LocalDate.now() :
                LocalDate.parse(expenseDto.getTransactionDate()));

        return expense;
    }
}
