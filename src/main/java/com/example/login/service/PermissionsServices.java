package com.example.login.service;

import com.example.login.dto.PermissionDto;
import com.example.login.entity.PermissionEntity;
import com.example.login.exception.ResourceNotFoundException;
import com.example.login.map.PermissionMap;
import com.example.login.repository.PermissionRepository;
import com.example.login.service.abstraction.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionsServices implements IPermissionService {
    @Autowired
    private PermissionMap permissionMap;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public PermissionDto add(PermissionDto permissionDto) {
        PermissionEntity permission = permissionMap.toEntity(permissionDto);
        PermissionEntity permissionNew = permissionRepository.save(permission);
        return permissionMap.toDto(permissionNew);
    }

    @Override
    public PermissionDto update(Long id, PermissionDto permissionDto) {
        PermissionEntity permissionSaved = permissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("permiso con el id  " + id + " no encontrado"));
        permissionSaved.setName(permissionDto.getName());
        PermissionEntity permissionNew = permissionRepository.save(permissionSaved);
        return permissionMap.toDto(permissionNew);
    }

    @Override
    public PermissionDto getById(Long id) {
        PermissionEntity permission = permissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("permiso con el id  " + id + " no encontrado"));
        return permissionMap.toDto(permission);
    }

    @Override
    public PermissionDto getByName(String name) {
        PermissionEntity permission = permissionRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("permiso con el nombre  " + name + " no encontrado"));
        return permissionMap.toDto(permission);
    }

    @Override
    public List<PermissionDto> getAll() {
        return permissionRepository.findAll().stream()
                .map(permissionMap::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!permissionRepository.existsById(id)) {
            throw new ResourceNotFoundException("permiso con el id  " + id + " no encontrado");
        }
        permissionRepository.deleteById(id);
    }
}
