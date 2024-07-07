package com.example.springboot.expensetracker.service;

import com.example.springboot.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
