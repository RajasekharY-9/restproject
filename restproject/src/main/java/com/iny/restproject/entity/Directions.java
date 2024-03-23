package com.iny.restproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Directions {

    @Id
    @Column(name = "Direction_Id")
    private String directionId;
    @Column(name = "Direction_Cycle")
    private String directionCycle;

    @Column(name = "Company_Code")
    private String companyCode;

    @Column(name = "Created_DateTime", nullable = false, updatable = false)
    private LocalDateTime createdDateTime = LocalDateTime.now();

    @Column(name = "Updated_DateTime")
    private LocalDateTime updatedDateTime = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "User_Id") // Name of the foreign key column in the Directions table
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDirectionId() {
        return directionId;
    }

    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    public String getDirectionCycle() {
        return directionCycle;
    }

    public void setDirectionCycle(String directionCycle) {
        this.directionCycle = directionCycle;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
