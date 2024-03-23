package com.iny.restproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class DirectionDTO {
    private String directionId;
    private String directionCycle;
    private String companyCode;
    private LocalDateTime updatedDateTime = LocalDateTime.now();
    private LocalDateTime createdDateTime = LocalDateTime.now();
    public String getDirectionId() {
        return directionId;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
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

    public DirectionDTO(String directionId, String directionCycle, String companyCode) {
        this.directionId = directionId;
        this.directionCycle = directionCycle;
        this.companyCode = companyCode;
    }

    public DirectionDTO() {
    }
// Constructors, Getters, Setters
}
