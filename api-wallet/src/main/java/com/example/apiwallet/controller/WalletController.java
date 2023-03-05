package com.example.apiwallet.controller;

import com.example.apiwallet.model.Wallet;
import com.example.apiwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Wallet wallet){
        return new ResponseEntity(walletService.save(wallet), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> search(@PathVariable Long id){
        return new ResponseEntity(walletService.findById(id), HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<?> modify(@RequestBody Wallet wallet){
        walletService.update(wallet);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        walletService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
