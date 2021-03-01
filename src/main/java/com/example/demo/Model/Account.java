package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="account")
@Getter
@Setter
public class Account {

    public Account(Integer id, String firstname, String lastname, String email, String password, Boolean locked, Boolean enabled) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean locked;
    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="adminid", nullable=false)
    private Admin admin;

    public Account(){

    }


}
