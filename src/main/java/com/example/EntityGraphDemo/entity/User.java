package com.example.EntityGraphDemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(name = "user-posts",
        attributeNodes = {
                @NamedAttributeNode(value = "posts", subgraph = "posts"),
                @NamedAttributeNode(value = "company")
        },
        subgraphs = @NamedSubgraph(name = "posts", attributeNodes = @NamedAttributeNode("post")))
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<UserPost> posts = new ArrayList<>();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<UserPost> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPost> posts) {
        this.posts = posts;
    }
}
