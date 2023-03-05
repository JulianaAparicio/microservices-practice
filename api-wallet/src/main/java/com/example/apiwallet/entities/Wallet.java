package com.example.apiwallet.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "wallets")
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "document_type")
    private String documentType;

    @NotNull
    @Column(name = "number_id")
    private String document;

    @NotNull
    @Column
    @ManyToOne
    @JoinColumn(name = "currency_code")
    private Currency currency;

    @NotNull
    @Column
    private Double balance;



}
