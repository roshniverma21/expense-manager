package com.example.springboot.expensetracker.service;

import com.example.springboot.expensetracker.entity.Expense;
import com.example.springboot.expensetracker.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);

    Expense getExpenseById(Long id) throws ResourceNotFoundException;

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetailsById(Expense expense, Long id);
}
