package com.romulo.authmanager.mappers;

import org.mapstruct.Mapper;

import com.romulo.authmanager.dto.UserDTO;
import com.romulo.authmanager.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO dto);
    
}
