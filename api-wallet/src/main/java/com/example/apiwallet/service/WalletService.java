package com.example.apiwallet.service;

import com.example.apiwallet.model.Wallet;
import com.example.apiwallet.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    IWalletRepository walletRepository;

    public Wallet save(Wallet wallet){
        return null;
    }

    public Wallet findById(Long id){
        return null;
    }

    public Wallet update(Wallet wallet){
        return null;
    }

    public void deleteById(Long id){
    }


}
