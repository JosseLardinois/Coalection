package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="admin")
@Getter
@Setter
public class Admin {

    public Admin(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL)
    private Set<Account> accounts;


    public Admin(){

    }

}
