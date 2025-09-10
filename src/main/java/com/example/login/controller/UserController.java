package com.example.login.controller;

import com.example.login.dto.UserDto;
import com.example.login.service.abstraction.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserDto> add(@Valid  @RequestBody UserDto userDto){
        UserDto user = iUserService.add(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@Valid @PathVariable Long id, @RequestBody UserDto userDto){
        UserDto user = iUserService.update(id, userDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String userName){
        UserDto user = iUserService.findByUsername(userName);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> users = iUserService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto user = iUserService.getById(id);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iUserService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
