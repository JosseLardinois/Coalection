package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="party")
@Getter
@Setter
public class Party {
    public Party(Integer id, String name, String description, Boolean ispartynational) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ispartynational = ispartynational;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean ispartynational;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partyleaderid", referencedColumnName = "id")
    private PartyLeader partyLeader;


    public Party() {

    }
}
