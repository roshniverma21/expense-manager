package com.example.springboot.expensetracker.controller;

import com.example.springboot.expensetracker.entity.Expense;
import com.example.springboot.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public Page<Expense> getExpensesList(Pageable page) {
        return expenseService.getAllExpenses(page);
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id) {
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam("id") Long id) {
        expenseService.deleteExpenseById(id);
        return "the expense is deleted with id: " + id;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetailsById(@RequestBody Expense expense, @PathVariable("id") Long id) {
        return expenseService.updateExpenseDetailsById(expense, id);
    }
}
