package com.dashboard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcement")
@Setter
@Getter
@NoArgsConstructor
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String text;

    @Column
    @Temporal(TemporalType.DATE)
    private Date created;

    public Announcement(String text){
        this.text = text;
    }
}
