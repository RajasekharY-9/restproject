package com.iny.restproject.repo;

import com.iny.restproject.dto.UserRequestDTO;
import com.iny.restproject.entity.Directions;
import com.iny.restproject.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public void addUser(UserRequestDTO request) throws UserValidationException;
    public UserRequestDTO getUser(String userId) throws  UserValidationException;


    public List<User> getAllUsersWithDirections();
}
