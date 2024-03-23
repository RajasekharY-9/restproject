package com.iny.restproject.entity;

import com.iny.restproject.dto.DirectionDTO;
import com.iny.restproject.dto.UserRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserRequestDTO toUserRequestDTO(User user) {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserId(user.getUserId());

        List<DirectionDTO> directionDTOs = new ArrayList<>();
        for (Directions direction : user.getDirections()) {
            DirectionDTO directionDTO = new DirectionDTO();
            directionDTO.setDirectionId(direction.getDirectionId());
            directionDTO.setDirectionCycle(direction.getDirectionCycle());
            directionDTO.setCompanyCode(direction.getCompanyCode());
            directionDTOs.add(directionDTO);
        }
        userRequestDTO.setDirections(directionDTOs);

        return userRequestDTO;
    }
}
