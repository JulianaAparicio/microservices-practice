package com.example.apicustomer.controllers;

import com.example.apicustomer.dtos.CustomerDTO;
import com.example.apicustomer.exceptions.NotFoundException;
import com.example.apicustomer.entities.Customer;
import com.example.apicustomer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> search(@PathVariable String idNumber, String idType) throws NotFoundException {
        return new ResponseEntity<>(customerService.findByIdNumberAndType(idNumber, idType), HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<?> modify(@RequestBody CustomerDTO customerDTO) throws NotFoundException {
        customerService.update(customerDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        customerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
