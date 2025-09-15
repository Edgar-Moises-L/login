//package com.example.login.map;
//
//import com.example.login.dto.RoleDto;
//import com.example.login.entity.RoleEntity;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RoleMap {
//
//    public RoleDto toDto(RoleEntity entity) {
//        if (entity == null) {
//            return null;
//        }
//        RoleDto dto = new RoleDto();
//        dto.setId(entity.getId());
//        dto.setName(entity.getName());
//        return dto;
//    }
//
//    public RoleEntity toEntity(RoleDto dto) {
//        if (dto == null) {
//            return null;
//        }
//        RoleEntity entity = new RoleEntity();
//        entity.setId(dto.getId());
//        entity.setName(dto.getName());
//        return entity;
//    }
//}
