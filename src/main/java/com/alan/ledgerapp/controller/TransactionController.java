package com.alan.ledgerapp.controller;

import com.alan.ledgerapp.model.Transaction;
import com.alan.ledgerapp.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * 获取所有交易
     */
    @GetMapping
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    /**
     * 创建新交易
     */
    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        Transaction saved = transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

