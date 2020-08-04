package com.vtb.kortunov.lesson21.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity

@Table(name = "users")
@Scope("prototype")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("[Id: %d], [Name: %s], [Age: %d]", id, name, age);
    }
}
