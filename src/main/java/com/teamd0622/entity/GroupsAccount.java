package com.teamd0622.entity;

import lombok.Data;

@Data
public class GroupsAccount {
    private Integer id;
    private String owner;
    private Integer balance;
    private String currency;
    private String mission_vision;
    private Integer created_at;
}
