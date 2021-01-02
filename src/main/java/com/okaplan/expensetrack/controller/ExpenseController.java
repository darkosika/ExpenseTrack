package com.okaplan.expensetrack.controller;

import com.okaplan.expensetrack.model.Expense;
import com.okaplan.expensetrack.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping("expenses")
    public ResponseEntity<List<Expense>> getLists (){
       List<Expense> expenses = expenseService.findAll();
       return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
