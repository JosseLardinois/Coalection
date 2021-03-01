package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.sql.Blob;

@Entity
@Table(name="partyleader")
@Getter
@Setter
public class PartyLeader {

    public PartyLeader(Integer id, String name) {
        this.id = id;
        this.name = name;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore//against getting records within records
    @OneToOne(mappedBy = "partyLeader")
    private Party party;

    public PartyLeader() {

    }
}
