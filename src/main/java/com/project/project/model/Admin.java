package com.project.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "admin", schema = "contactcenter")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_admin", nullable=false, updatable=false)
    public int id_admin;
    @NotNull

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="id_user",
            referencedColumnName = "id_user",
            insertable = false,
            updatable = false)
    private User user;
/*
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "Admin")
    private Set<Survey> statt = new HashSet<>();
  */
@OneToMany(
        targetEntity=News.class,
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "admin")
private Set<News> news = new HashSet<>();

    protected Admin(){}


    @Override
    public String toString() {
        return "Admin{" +
                "id_admin=" + id_admin +
                '}';
    }
}

