package com.example.EntityGraphDemo.mapper;

import com.example.EntityGraphDemo.entity.User;
import com.example.EntityGraphDemo.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserDto toDto(User user);
}
