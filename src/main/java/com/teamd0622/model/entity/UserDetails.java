package com.teamd0622.model.entity;

import lombok.*;


@Data
public class UserDetails {
    private Integer id;
    private String username;
    private Integer age;
    private String email;
    private String address;
    private String user_password;
}
