package com.example.SimpleBank.Service;

import com.example.SimpleBank.Dto.CreateCustomerRequest;
import com.example.SimpleBank.Dto.CustomerDto;
import com.example.SimpleBank.Dto.CustomerDtoConverter;
import com.example.SimpleBank.Dto.UpdateCustomerRequest;
import com.example.SimpleBank.Exception.CustomerNotFoundException;
import com.example.SimpleBank.Model.Customer;
import com.example.SimpleBank.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CustomerDto createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer(request.getId(),
                request.getName(),
                request.getSurname(),
                request.getDateOfBirth(),
                request.getCity());

        customerRepository.save(customer);

        CustomerDto customerDto = customerDtoConverter.convert(customer);

        return customerDto;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();


        for (Customer customer : customers) {

            customerDtoList.add(customerDtoConverter.convert(customer));
        }

        return customerDtoList;
    }

    public CustomerDto getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return customer.map(customerDtoConverter::convert).orElse(new CustomerDto());
    }

    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto updateCustomerById(Integer id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        if (!updateCustomerRequest.getName().equals("")) customer.setName(updateCustomerRequest.getName());
        if (!updateCustomerRequest.getSurname().equals("")) customer.setSurname(updateCustomerRequest.getSurname());
        if (!updateCustomerRequest.getCity().equals("")) customer.setCity(updateCustomerRequest.getCity());
        if (updateCustomerRequest.getDateOfBirth() != null) customer.setDateOfBirth(updateCustomerRequest.getDateOfBirth());

        return customerDtoConverter.convert(customerRepository.save(customer));


    }
}
