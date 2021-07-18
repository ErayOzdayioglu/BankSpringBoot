package com.example.SimpleBank.Dto;

import com.example.SimpleBank.Model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCity(customer.getCity());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setDateOfBirth(customer.getDateOfBirth());

        return customerDto;
    }
}
