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
    public List<Expense> getExpensesList(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public String getExpenseById(@PathVariable("id") Long id){
        return "the expense id: " + id;
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam("id") Long id){
        return "the deleteed expense id: " + id;
    }
}
