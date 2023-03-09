package com.teamd0622.mapper;

import com.teamd0622.model.entity.TransferMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// TODO: 09/03/2023 check the balance and account whether exists.
@Mapper
public interface TransferMoneyMapper {
    int addTransferMoney(TransferMoney transferMoney);
    int updateTransferMoney(TransferMoney transferMoney);
    int deleteTransferMoneyById(Integer id);
    TransferMoney getTransferMoneyById(Integer id);
    List<TransferMoney> getAllTransferMoney();
}
