package com.example.services;

import com.example.entities.Customer;
import com.example.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void  save(Customer c)throws Exception{
        customerRepository.save(c);
    }
}
