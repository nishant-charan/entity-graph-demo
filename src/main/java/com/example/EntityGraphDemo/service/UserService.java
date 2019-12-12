package com.example.EntityGraphDemo.service;

import com.example.EntityGraphDemo.entity.User;
import com.example.EntityGraphDemo.repository.UserRepository;
import com.example.EntityGraphDemo.specification.SearchCriteria;
import com.example.EntityGraphDemo.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList(String type) {
        UserSpecification spec = null;
        if (type != null) {
            spec = new UserSpecification(new SearchCriteria("type", ":", type));
        }
        return userRepository.findAll(spec);
    }
}
