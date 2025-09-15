package com.example.login.controller;

import com.example.login.dto.PermissionDto;
import com.example.login.service.abstraction.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/permissions")
public class PermissionController {
    @Autowired
    private IPermissionService permissionServices;

    @PostMapping
    public ResponseEntity<PermissionDto> add(@RequestBody PermissionDto permissionDto){
        PermissionDto permission = permissionServices.add(permissionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(permission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionDto> update(@PathVariable Long id, @RequestBody PermissionDto permissionDto){
        PermissionDto permission = permissionServices.update(id, permissionDto);
        return ResponseEntity.ok(permission);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PermissionDto> getByName(@PathVariable String name){
        PermissionDto permissionDto = permissionServices.getByName(name);
        return ResponseEntity.ok(permissionDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionDto> getById(@PathVariable Long id){
        PermissionDto permissionDto = permissionServices.getById(id);
        return ResponseEntity.ok(permissionDto);
    }

    @GetMapping
    public ResponseEntity<List<PermissionDto>> getAll(){
        List<PermissionDto> permissionDto = permissionServices.getAll();
        return ResponseEntity.ok(permissionDto);
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id){
        permissionServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
