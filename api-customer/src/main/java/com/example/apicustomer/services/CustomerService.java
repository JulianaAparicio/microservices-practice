package com.example.apicustomer.services;

import com.example.apicustomer.dtos.CustomerDTO;
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

    public void update(CustomerDTO customerDTO) throws NotFoundException {
        Customer existingCustomer = customerRepository.findById(customerDTO.getId())
                .orElseThrow(() -> new NotFoundException("The customer was not found."));
        existingCustomer.setFirstName(customerDTO.getFirstName());
        existingCustomer.setBirthDate(customerDTO.getBirthDate());
        existingCustomer.setLastName(customerDTO.getLastName());
        existingCustomer.setGenre(customerDTO.getGenre());

        customerRepository.save(existingCustomer);
    }

    public void deleteById(Long id) throws NotFoundException {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The customer was not found."));
        customerRepository.deleteById(id);
    }


}
