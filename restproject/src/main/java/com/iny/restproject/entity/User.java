package com.iny.restproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "User_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Pk_Id", columnDefinition = "UUID")
    private UUID userPkId;
    @Column(name = "User_Id")
    private String userId;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    //  @JsonIgnore
    private List<Directions> directions;




    public UUID getUserPkId() {
        return userPkId;
    }

    public void setUserPkId(UUID userPkId) {
        this.userPkId = userPkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Directions> getDirections() {
        return directions;
    }

    public void setDirections(List<Directions> directions) {
        this.directions = directions;
    }

    public User(UUID userPkId, String userId) {
        this.userPkId = userPkId;
        this.userId = userId;


    }

    public User() {
    }
    // Constructors, Getters, Setters
}