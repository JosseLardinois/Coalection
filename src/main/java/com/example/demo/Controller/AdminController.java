package com.example.demo.Controller;

import com.example.demo.Model.Account;
import com.example.demo.Model.Admin;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("")
    public List<Admin> list(){
        return adminService.listAllAccounts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id){
        try{
            Admin admin = adminService.getAdmin(id);
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Admin admin){

        adminService.saveAdmin(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Integer id){
        try{
            Admin existAdmin = adminService.getAdmin(id);
            admin.setId(id);
            adminService.saveAdmin(admin);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        adminService.deleteAdmin(id);
    }

}
