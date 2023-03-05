package com.example.apicustomer.services;

import com.example.apicustomer.exceptions.NotFoundException;
import com.example.apicustomer.entities.Customer;
import com.example.apicustomer.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findByIdNumberAndType(String idNumber, String idType) throws NotFoundException {
        return customerRepository.findByIdNumberAndType(idNumber, idType).orElseThrow(() -> new NotFoundException("The " +
                "customer with the id type and number: " + idType + ", " + idNumber + " was not found."));
    }

    public Customer update(Customer customer) throws NotFoundException {
        Customer existingCustomer = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new NotFoundException("The customer was not found."));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setBirthDate(customer.getBirthDate());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setGenre(customer.getGenre());

        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    public void deleteById(Long id) throws NotFoundException {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The customer was not found."));
        customerRepository.deleteById(id);
    }


}
