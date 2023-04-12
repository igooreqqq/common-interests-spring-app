package com.meow.commoninterests.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Interests> interestsList = new ArrayList<>();

    public User(Long id, String username, String email, List<Interests> interestsList) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.interestsList = interestsList;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Interests> getInterestsList() {
        return interestsList;
    }

    public void setInterestsList(List<Interests> interestsList) {
        this.interestsList = interestsList;
    }
}
