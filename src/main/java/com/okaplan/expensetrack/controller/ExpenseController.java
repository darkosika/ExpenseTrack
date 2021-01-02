package com.okaplan.expensetrack.controller;

import com.okaplan.expensetrack.model.Expense;
import com.okaplan.expensetrack.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    @PostMapping("expenses")
    public ResponseEntity<Expense> save (@RequestBody Expense expense){
       Expense _expense = expenseService.save(expense);
       return new ResponseEntity<>(_expense, HttpStatus.OK);
    }

    @GetMapping("expenses/{id}")
    public ResponseEntity<Expense> save (@PathVariable("id") Long id){
        Expense _expense = expenseService.findById(id);
        return new ResponseEntity<>(_expense, HttpStatus.OK);
    }

    @DeleteMapping("expenses/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Long id){
        expenseService.delete(id);
        return new ResponseEntity<>("Expense is deleted Successfully", HttpStatus.OK);
    }
}
