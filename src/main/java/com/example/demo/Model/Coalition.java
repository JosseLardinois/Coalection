package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coalition")
@Getter
@Setter
public class Coalition {
    public Coalition(Integer id, String name, Date date ) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date date;

    public Coalition() {

    }
}
