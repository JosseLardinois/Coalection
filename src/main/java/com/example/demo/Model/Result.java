package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "result")
@Getter
@Setter
public class Result {
    public Result(Integer id, Date date,  String name) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date date;

    public Result() {

    }
}
