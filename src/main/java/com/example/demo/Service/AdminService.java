package com.example.demo.Service;

import com.example.demo.Model.Account;
import com.example.demo.Model.Admin;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> listAllAccounts() {
        return adminRepository.findAll();
    }

    public void saveAdmin(Admin admin) { adminRepository.save(admin);}

    public Admin getAdmin(Integer id) {return adminRepository.findById(id).get();
    }
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}
