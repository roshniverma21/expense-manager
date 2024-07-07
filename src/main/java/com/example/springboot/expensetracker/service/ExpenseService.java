package com.example.springboot.expensetracker.service;

import com.example.springboot.expensetracker.entity.Expense;
import com.example.springboot.expensetracker.exceptions.ExpenseNotFoundException;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);

    Expense getExpenseById(Long id) throws ExpenseNotFoundException;

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetailsById(Expense expense, Long id);
}
