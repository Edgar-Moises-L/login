package com.example.login.service;

import com.example.login.dto.UserDto;
import com.example.login.entity.UserEntity;
import com.example.login.exception.ResourceNotFoundException;
import com.example.login.map.UserMap;
import com.example.login.repository.UserRepository;
import com.example.login.service.abstraction.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMap userMap;

    @Override
    public UserDto findByUsername(String userName) {
        UserEntity user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con username " + userName + " no encontrado"));
        return userMap.toDto(user);
    }

    @Override
    public UserDto add(UserDto userDto) {
        UserEntity user = userMap.toEntity(userDto);
        UserEntity newUser = userRepository.save(user);
        return userMap.toDto(newUser);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        UserEntity userSaved = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));

        userSaved.setEmail(userDto.getEmail());
        userSaved.setUserName(userDto.getUserName());
        userSaved.setPassword(userDto.getPassword());
        userSaved.setRoles(userDto.getRoles());

        UserEntity updatedUser = userRepository.save(userSaved);
        return userMap.toDto(updatedUser);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMap::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        return userMap.toDto(user);
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario con ID " + id + " no encontrado");
        }
        userRepository.deleteById(id);
    }
}
