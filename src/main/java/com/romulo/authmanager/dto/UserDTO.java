package com.romulo.authmanager.dto;

import java.util.List;

import com.romulo.authmanager.enumeration.Role;

public record UserDTO(String username, String password, List<Role> roles) {

}
