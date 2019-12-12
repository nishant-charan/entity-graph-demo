package com.example.EntityGraphDemo.mapper;

import com.example.EntityGraphDemo.entity.Company;
import com.example.EntityGraphDemo.model.CompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CompanyMapper {
    public abstract CompanyDto toDto(Company company);
}
