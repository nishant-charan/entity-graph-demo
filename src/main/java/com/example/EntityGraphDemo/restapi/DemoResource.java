package com.example.EntityGraphDemo.restapi;

import com.example.EntityGraphDemo.entity.User;
import com.example.EntityGraphDemo.entity.UserPost;
import com.example.EntityGraphDemo.mapper.CompanyMapper;
import com.example.EntityGraphDemo.mapper.PostMapper;
import com.example.EntityGraphDemo.mapper.UserMapper;
import com.example.EntityGraphDemo.model.PostDto;
import com.example.EntityGraphDemo.model.UserDto;
import com.example.EntityGraphDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoResource {

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private UserMapper userMapper;

    @Autowired(required = true)
    private CompanyMapper companyMapper;

    @Autowired(required = true)
    private PostMapper postMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUserList(@RequestParam(value = "type", required = false) String type) {
        Long startTime = System.currentTimeMillis();
        List<User> userDbList = userService.getUserList(type);
        List<UserDto> userList = new ArrayList<>();
        for (User user : userDbList) {
            UserDto userDto = userMapper.toDto(user);
            List<PostDto> postDtos = new ArrayList<>();
            for (UserPost userPost : user.getPosts()) {
                postDtos.add(postMapper.toDto(userPost.getPost()));
            }
            userDto.setCompanyDto(companyMapper.toDto(user.getCompany()));
            userDto.setPostList(postDtos);
            userList.add(userDto);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("Time taken :: " + (endTime - startTime));
        return ResponseEntity.ok(userList);
    }
}
