package com.example.login.map;

import com.example.login.dto.UserDto;
import com.example.login.entity.UserEntity;
import org.springframework.stereotype.Component;



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
        dto.setRoles(entity.getRoles());


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
        entity.setRoles(dto.getRoles());

        return entity;
    }

}