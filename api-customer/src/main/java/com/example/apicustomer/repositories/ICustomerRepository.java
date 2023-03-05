package com.example.apicustomer.repositories;

import com.example.apicustomer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdNumberAndType(String idNumber, String idType);

}
