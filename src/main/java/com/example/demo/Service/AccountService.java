package com.example.demo.Service;

import com.example.demo.Model.Account;
import com.example.demo.Model.User;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public List<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    public void saveAccount(Account account) { accountRepository.save(account);}

    public Account getAccount(Integer id) {
        return accountRepository.findById(id).get();
    }
    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
}
