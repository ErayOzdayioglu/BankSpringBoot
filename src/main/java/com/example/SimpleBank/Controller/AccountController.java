package com.example.SimpleBank.Controller;


import com.example.SimpleBank.Dto.*;
import com.example.SimpleBank.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PutMapping("/add")
    public ResponseEntity<Void> addMoney(@RequestBody MoneyRequest request) {
         accountService.addMoney(request);
         return ResponseEntity.ok().build();
    }
}
