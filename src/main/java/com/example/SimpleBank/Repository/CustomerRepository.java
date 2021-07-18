package com.example.SimpleBank.Repository;

import com.example.SimpleBank.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
