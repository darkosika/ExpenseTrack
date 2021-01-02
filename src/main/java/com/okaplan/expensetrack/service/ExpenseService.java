package com.okaplan.expensetrack.service;

import com.okaplan.expensetrack.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAll();
}
