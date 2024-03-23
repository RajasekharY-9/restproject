package com.iny.restproject.repo;

import com.iny.restproject.dto.DirectionDTO;
import com.iny.restproject.dto.UserRequestDTO;
import com.iny.restproject.entity.Directions;
import com.iny.restproject.entity.User;
import com.iny.restproject.entity.UserMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    @Override
    public void addUser(UserRequestDTO request) throws UserValidationException {
        User user = new User();
        user.setUserId(request.getUserId());

        List<Directions> directions = new ArrayList<>();
        for (DirectionDTO directionDTO : request.getDirections()) {
            Directions direction = new Directions();
            // Generate UUID for Directions entity
            direction.setDirectionId(UUID.randomUUID().toString());
            direction.setDirectionCycle(directionDTO.getDirectionCycle());
            direction.setCompanyCode(directionDTO.getCompanyCode());

            // Establish bidirectional relationship
            direction.setUser(user);

            directions.add(direction);
        }
        user.setDirections(directions);

        // Save User entity and associated Directions entities
        userRepository.save(user);
    }
    @Override
    public UserRequestDTO getUser(String userId) throws UserValidationException {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return mapUserToUserRequestDTO(user);
        } else {
            throw new UserValidationException("User not found with userId: " + userId);
        }
    }


    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsersWithDirections() {
        return entityManager.createQuery(
                        "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.directions", User.class)
                .getResultList();
    }
    private UserRequestDTO mapUserToUserRequestDTO(User user) {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserId(user.getUserId());

        List<DirectionDTO> directionDTOs = user.getDirections().stream()
                .map(direction -> {
                    DirectionDTO directionDTO = new DirectionDTO();
                    directionDTO.setDirectionId(direction.getDirectionId());
                    directionDTO.setDirectionCycle(direction.getDirectionCycle());
                    directionDTO.setCompanyCode(direction.getCompanyCode());
                    directionDTO.setCreatedDateTime(direction.getCreatedDateTime());
                    directionDTO.setUpdatedDateTime(direction.getUpdatedDateTime());
                    return directionDTO;
                })
                .collect(Collectors.toList());

        userRequestDTO.setDirections(directionDTOs);
        return userRequestDTO;
    }
}






