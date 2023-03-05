package com.example.apiwallet.controllers;

import com.example.apiwallet.dtos.WalletDTO;
import com.example.apiwallet.exceptions.NotFoundException;
import com.example.apiwallet.entities.Wallet;
import com.example.apiwallet.services.WalletService;
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
        return new ResponseEntity<>(walletService.save(wallet), HttpStatus.CREATED);
    }

    @GetMapping("/find-document-currency/{documentType}/{document}/{currencyCode}")
    public Wallet findByDocumentAndCurrency(@PathVariable String documentType,
                                            @PathVariable String document,
                                            @PathVariable String currencyCode) throws Exception {
        return walletService.findByDocumentAndCurrency(documentType, document, currencyCode);
    }

    @PutMapping
    public ResponseEntity<?> modify(@RequestBody WalletDTO walletDTO) throws NotFoundException {
        walletService.update(walletDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
