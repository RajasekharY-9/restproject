package com.iny.restproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data

public class UserRequestDTO {
    private String userId;
    private List<DirectionDTO> directions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<DirectionDTO> getDirections() {
        return directions;
    }

    public void setDirections(List<DirectionDTO> directions) {
        this.directions = directions;
    }

    public UserRequestDTO(String userId, List<DirectionDTO> directions) {
        this.userId = userId;
        this.directions = directions;
    }
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<Map<String, Object>> directionMaps = new ArrayList<>();
        for (DirectionDTO directionDTO : directions) {
            Map<String, Object> directionMap = new HashMap<>();
            directionMap.put("directionId", directionDTO.getDirectionId());
            directionMap.put("directionCycle", directionDTO.getDirectionCycle());
            directionMap.put("companyCode", directionDTO.getCompanyCode());
            directionMaps.add(directionMap);
        }
        map.put("directions", directionMaps);

        return map;
    }

    public UserRequestDTO() {
    }
    // Constructors, Getters, Setters
}
