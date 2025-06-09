package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.SaveUserRequest;
import com.example.authorbookrest.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SaveUserRequest saveUserRequest);
}