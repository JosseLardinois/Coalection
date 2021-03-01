package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="party")
@Getter
@Setter
public class Party {
    public Party(Integer id, String description, Boolean isPartyNational, Integer partyLeaderId, String name) {
        this.id = id;
        this.description = description;
        this.isPartyNational = isPartyNational;
        this.partyLeaderId = partyLeaderId;
        this.name = name;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Boolean isPartyNational;
    private Integer partyLeaderId;
    private String name;

    public Party() {

    }
}
