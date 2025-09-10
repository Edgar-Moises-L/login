package com.example.login.service;

import com.example.login.dto.RoleDto;
import com.example.login.entity.RoleEntity;
import com.example.login.exception.ResourceNotFoundException;
import com.example.login.map.RoleMap;
import com.example.login.repository.RoleRepository;
import com.example.login.service.abstraction.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService implements IRolService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMap roleMap;

    @Override
    public RoleDto add(RoleDto rolDto) {
        RoleEntity role = roleMap.toEntity(rolDto);
        RoleEntity roleNew = roleRepository.save(role);
        return roleMap.toDto(roleNew);
    }

    @Override
    public RoleDto update(Long id, RoleDto roleDto) {
        RoleEntity roleSaved = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol con el ID " + id + " no encontrado"));
        roleSaved.setId(roleDto.getId());
        roleSaved.setName(roleDto.getName());
        RoleEntity roleUpdate = roleRepository.save(roleSaved);
        return roleMap.toDto(roleUpdate);
    }

    @Override
    public List<RoleDto> getAll() {
        return roleRepository.findAll().stream()
                .map(roleMap::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto getById(Long id) {
        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol con el ID " + id + " no encontrado") ) ;
        return roleMap.toDto(role);
    }

    @Override
    public void deleteById(Long id) {
    if(!roleRepository.existsById(id)){
        throw new ResourceNotFoundException("Rol con el ID " + id + " no encontrado");
    }
    roleRepository.deleteById(id);
    }
}




