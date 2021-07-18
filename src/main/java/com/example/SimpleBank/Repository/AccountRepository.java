package com.example.SimpleBank.Repository;

import com.example.SimpleBank.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
