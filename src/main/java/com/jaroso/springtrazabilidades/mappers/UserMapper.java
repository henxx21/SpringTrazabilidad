package com.jaroso.springtrazabilidades.mappers;

import com.jaroso.springtrazabilidades.dtos.UserCreateDto;
import com.jaroso.springtrazabilidades.dtos.UserDto;
import com.jaroso.springtrazabilidades.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(Usuario usuario);
    Usuario toEntity(UserCreateDto userDto);
}
