package com.example.login.service.abstraction;

import com.example.login.dto.RoleDto;

import java.util.List;

public interface IRolService {
    RoleDto add(RoleDto rol);
    RoleDto update(Long id, RoleDto rol);
    List<RoleDto> getAll();
    RoleDto getById(Long id);
    void deleteById(Long id);
}
