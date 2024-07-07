package com.example.springboot.expensetracker.service;

import com.example.springboot.expensetracker.entity.Expense;
import com.example.springboot.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            return expense.get();
        }

        throw new RuntimeException("expense is not found for id : " + id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
             expenseRepository.deleteById(id);
            return;
        }

        throw new RuntimeException("expense is not found for id : " + id);
    }
}
