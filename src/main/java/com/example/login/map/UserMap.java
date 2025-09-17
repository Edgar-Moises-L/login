package com.example.login.map;

import com.example.login.dto.UserDto;
import com.example.login.entity.ERole;
import com.example.login.entity.RoleEntity;
import com.example.login.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMap {

    public UserDto toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setRoles(entityToString(entity.getRole()));

        return dto;
    }


    public UserEntity toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    private Set<String> entityToString(Set<RoleEntity> roles) {
        return roles.stream()
                .map(r -> r.getRoleEnum().name())
                .collect(Collectors.toSet());
    }
}

