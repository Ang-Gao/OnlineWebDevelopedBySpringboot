package com.teamd0622.entity;

import lombok.Data;

@Data
public class TransferMoney {
    private Integer id;
    private Integer from_account_id;
    private Integer to_account_id;
    private Integer amount;
    private Integer created_at;
}
