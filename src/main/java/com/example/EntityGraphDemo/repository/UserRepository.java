package com.example.EntityGraphDemo.repository;

import com.example.EntityGraphDemo.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @EntityGraph(value = "user-posts" , type= EntityGraph.EntityGraphType.FETCH)
    @Override
    List<User> findAll(@Nullable Specification<User> var1);
}
