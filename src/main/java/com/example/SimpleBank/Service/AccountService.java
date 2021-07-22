package com.example.SimpleBank.Service;

import com.example.SimpleBank.Dto.AccountDto;
import com.example.SimpleBank.Dto.AccountDtoConverter;
import com.example.SimpleBank.Dto.MoneyRequest;
import com.example.SimpleBank.Dto.CreateAccountRequest;
import com.example.SimpleBank.Exception.AccountNotFoundException;
import com.example.SimpleBank.Exception.InsufficientBalanceException;
import com.example.SimpleBank.Model.Account;
import com.example.SimpleBank.Repository.AccountRepository;
import com.example.SimpleBank.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest request) {
        Account account = new Account(request.getId(), request.getCustomerId(), BigDecimal.ZERO, LocalDateTime.now());
        return accountDtoConverter.convert(accountRepository.save(account));
    }

    public AccountDto getAccountById(Integer id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return accountDtoConverter.convert(account);
    }

    public void addMoney(MoneyRequest request) {
        Account account = accountRepository.findById(request.getAccountId()).
                orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (request.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            account.setBalance(account.getBalance().add(request.getAmount()));
            accountRepository.save(account);
        }

        // TODO amount is < 0 exception
    }

    public void withdrawMoney(MoneyRequest request) {
        Account account = accountRepository.findById(request.getAccountId()).
                orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (request.getAmount().compareTo(account.getBalance()) > 0) {
            throw new InsufficientBalanceException("You have not enough balance");
        }
        else {
            account.setBalance(account.getBalance().subtract(request.getAmount()));
            accountRepository.save(account);
        }
    }




}
