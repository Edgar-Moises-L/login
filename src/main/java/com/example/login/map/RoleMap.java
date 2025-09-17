package com.example.login.map;

import com.example.login.dto.RoleDto;
import com.example.login.entity.ERole;
import com.example.login.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoleMap {
    @Autowired
    private PermissionMap permissionMap;

    public RoleDto toDto(RoleEntity entity) {
        if (entity == null) {
            return null;
        }
        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getRoleEnum().name());
        dto.setPermission(
                entity.getPermission()
                        .stream()
                        .map(permissionMap::toDto)
                        .collect(Collectors.toSet())
        );

        return dto;
    }

    public RoleEntity toEntity(RoleDto dto) {
        if (dto == null) {
            return null;
        }
        RoleEntity entity = new RoleEntity();
        entity.setId(dto.getId());
        entity.setRoleEnum(ERole.valueOf(dto.getName()));
        entity.setPermission(
                dto.getPermission()
                        .stream()
                        .map(permissionMap::toEntity)
                        .collect(Collectors.toSet())
        );
        return entity;
    }
}
