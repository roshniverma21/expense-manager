package com.example.springboot.expensetracker.controller;

import com.example.springboot.expensetracker.entity.Expense;
import com.example.springboot.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getExpensesList() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam("id") Long id) {
        expenseService.deleteExpenseById(id);
        return "the expense is deleted with id: " + id;
    }

    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetailsById(@RequestBody Expense expense, @PathVariable("id") Long id){
        return expenseService.updateExpenseDetailsById(expense, id);
    }
}
