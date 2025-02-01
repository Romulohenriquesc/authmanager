package com.romulo.authmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romulo.authmanager.dto.UserDTO;
import com.romulo.authmanager.mappers.UserMapper;
import com.romulo.authmanager.model.User;
import com.romulo.authmanager.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserDTO dto) {

        var user = mapper.toEntity(dto);

        service.save(user);
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")    
    public User findByUsername(@PathVariable("username") String username) {
        return service.findByUsername(username);
    }

}
