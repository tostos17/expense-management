package com.pioneers.expense.controllers;

import com.pioneers.expense.dto.ExpenseDto;
import com.pioneers.expense.model.Expense;
import com.pioneers.expense.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/expense")
public class CoreController {

    private final ExpenseService expenseService;
    private String message = "";

    public CoreController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @GetMapping("/add")
    public String addExpense(Model model) {

        List<Expense> allExpenses = expenseService.getAllExpenses();
        allExpenses.sort(Comparator.comparing(Expense::getTransactionDate).reversed());

        model.addAttribute("pageTitle", "Save Expense");
        model.addAttribute("message", getMessage());
        model.addAttribute("expenses", allExpenses);

        setMessage("");

        return "index";
    }

    @PostMapping("/save")
    public String saveExpense(@RequestBody ExpenseDto expenseDto, Model model) {
        Expense expense = expenseService.saveExpense(expenseDto);
        System.out.println("Description is: " + expense.getDescription());

//        model.addAttribute("expenseTitle", "Saved");
        setMessage("Saved");

        return "index";
    }
}
