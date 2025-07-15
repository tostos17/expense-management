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

import java.util.List;

@Controller
@RequestMapping("/expense")
public class CoreController {

    private final ExpenseService expenseService;

    public CoreController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/add")
    public String addExpense(Model model) {

        List<Expense> allExpenses = expenseService.getAllExpenses();

        model.addAttribute("pageTitle", "Save Expense");
        model.addAttribute("message", "Saved");
        model.addAttribute("expenses", allExpenses);

        return "index";
    }

    @PostMapping("/save")
    public String saveExpense(@RequestBody ExpenseDto expenseDto, Model model) {
        Expense expense = expenseService.saveExpense(expenseDto);
        System.out.println("Description is: " + expense.getDescription());

        model.addAttribute("expenseTitle", "Saved");

        return "index";
    }
}
