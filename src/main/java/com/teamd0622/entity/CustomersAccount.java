package com.teamd0622.entity;

import lombok.Data;

@Data
public class CustomersAccount {
    private Integer id;
    private String owner;
    private Integer balance;
    private String currency;
    private String created_at;
}
