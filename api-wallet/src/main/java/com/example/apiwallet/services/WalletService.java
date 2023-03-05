package com.example.apiwallet.services;

import com.example.apiwallet.dtos.WalletDTO;
import com.example.apiwallet.exceptions.NotFoundException;
import com.example.apiwallet.entities.Wallet;
import com.example.apiwallet.repositories.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    IWalletRepository walletRepository;

    public Wallet save(Wallet wallet){
        return walletRepository.save(wallet);
    }

    public Wallet findByDocumentAndCurrency(String documentType, String idNumber, String currencyCode) throws NotFoundException {
        return walletRepository.findByDocumentTypeAndDocumentValueAndCurrency_Code(documentType, idNumber,
                currencyCode).orElseThrow(() -> new NotFoundException("The wallet was not found."));
    }

    public List<Wallet> findByDocument(String documentType, String idNumber) {
        return walletRepository.findByDocumentTypeAndDocumentValue(documentType, idNumber);
    }

    public void update(WalletDTO walletDTO) throws NotFoundException {
        Wallet existingWallet = walletRepository.findById(walletDTO.getId())
                .orElseThrow(() -> new NotFoundException("The wallet was not found."));

        existingWallet.setBalance(walletDTO.getBalance());
        walletRepository.save(existingWallet);
    }


}
