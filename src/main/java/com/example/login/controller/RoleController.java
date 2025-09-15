//package com.example.login.controller;
//
//import com.example.login.dto.RoleDto;
//import com.example.login.service.abstraction.IRolService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/roles")
//public class RoleController {
//    @Autowired
//    private IRolService iRolService;
//
//    @PostMapping
//    public ResponseEntity<RoleDto> add(@Valid @RequestBody RoleDto roleDto){
//        RoleDto rol = iRolService.add(roleDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(rol);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<RoleDto> update(@Valid @PathVariable Long id, @RequestBody RoleDto roleDto){
//        RoleDto role = iRolService.update(id,roleDto);
//        return ResponseEntity.ok(role);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<RoleDto>> getAll(){
//        List<RoleDto> roles = iRolService.getAll();
//        return ResponseEntity.ok(roles);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RoleDto> getById(@PathVariable Long id){
//        RoleDto role = iRolService.getById(id);
//        return ResponseEntity.ok(role);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        iRolService.deleteById(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//}
