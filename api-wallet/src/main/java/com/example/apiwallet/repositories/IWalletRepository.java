package com.example.apiwallet.repositories;

import com.example.apiwallet.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByDocumentTypeAndDocumentValueAndCurrency_Code(String documentType, String document, String currencyCode);

    List<Wallet> findByDocumentTypeAndDocumentValue(String documentType, String document);
}
