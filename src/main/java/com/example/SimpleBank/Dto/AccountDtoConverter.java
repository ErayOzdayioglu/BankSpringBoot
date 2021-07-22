package com.example.SimpleBank.Dto;

import com.example.SimpleBank.Model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    public AccountDto convert(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId( account.getId());
        accountDto.setBalance(account.getBalance());
        accountDto.setCreationDate(account.getCreationDate());
        accountDto.setCustomerId(account.getCustomerId());
        return  accountDto;

    }
}
