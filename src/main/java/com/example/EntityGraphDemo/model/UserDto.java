package com.example.EntityGraphDemo.model;

import java.util.List;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private CompanyDto companyDto;
    private List<PostDto> postList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CompanyDto getCompanyDto() {
        return companyDto;
    }

    public void setCompanyDto(CompanyDto companyDto) {
        this.companyDto = companyDto;
    }

    public List<PostDto> getPostList() {
        return postList;
    }

    public void setPostList(List<PostDto> postList) {
        this.postList = postList;
    }
}
