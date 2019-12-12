package com.example.EntityGraphDemo.mapper;

import com.example.EntityGraphDemo.entity.Post;
import com.example.EntityGraphDemo.model.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    public abstract PostDto toDto(Post post);
}
