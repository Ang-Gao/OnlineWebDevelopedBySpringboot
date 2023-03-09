package com.teamd0622.model.entity;

import lombok.Data;

@Data
public class TransferMoney {
    private Integer id;
    private Integer from_account_id;
    private Integer to_account_id;
    private Integer amount;
    private String created_at;
}
