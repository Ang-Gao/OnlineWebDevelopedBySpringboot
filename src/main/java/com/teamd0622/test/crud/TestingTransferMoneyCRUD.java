package com.teamd0622.test.crud;

import com.teamd0622.mapper.TransferMoneyMapper;
import com.teamd0622.model.entity.TransferMoney;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingTransferMoneyCRUD {
    //Transfer money need TWO EXISTED accounts.
    //FOR testing, ONLY implement CRUD without any service logic(e.g. transfer between accounts)
    @Autowired
    TransferMoneyMapper transferMoneyMapper;

    RandomGenerated rg = new RandomGenerated();
    public TransferMoney createNewTransferMoney(){
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.setId(rg.randomInt());
        transferMoney.setAmount(rg.randomInt());
        //如果是正常逻辑，需要操作两组数据的余额
        transferMoney.setFrom_account_id(1);
        transferMoney.setTo_account_id(3);
        return transferMoney;
    }
    //增加单条数据
    //TransferMoney负责记录转账记录，所以还需要同时操作customers_account和groups_account 来进行真正数据(balance)的更改
    @GetMapping("/test/addTransferMoneyTesting")
    public String addTransferMoneyTesting(){
        int msg = transferMoneyMapper.addTransferMoney(createNewTransferMoney());
        System.out.println("ADD NEW DATA>>>" + msg);
        return "\"ADD NEW DATA>>>\"";
    }

    @PostMapping("/test/updateTransferMoneyTesting")
    public String updateTransferMoneyTesting(){
        int msg = transferMoneyMapper.updateTransferMoney(createNewTransferMoney());
        System.out.println("UPDATE NEW DATA>>>" + msg);
        return "\"UPDATE NEW DATA>>>\"";
    }

    @DeleteMapping("/test/deleteTransferMoneyByIdTesting/{id}")
    public String deleteTransferMoneyByIdTesting(@PathVariable Integer id){
        transferMoneyMapper.deleteTransferMoneyById(id);
        return "DELETE";
    }

    @GetMapping("/test/getTransferMoneyByIdTesting/{id}")
    public String getTransferMoneysByIdTesting(@PathVariable Integer id){
        System.out.println(transferMoneyMapper.getTransferMoneyById(id));
        return "GET TRANSFER MONEY";
    }

    @GetMapping("/test/getAllTransferMoneyTesting")
    public String getAllTransferMoneyTesting(){
        List<TransferMoney> list = new ArrayList<>();
        list = transferMoneyMapper.getAllTransferMoney();
        for (TransferMoney tm : list){
            System.out.println(tm);
        }
        return "GET ALL TRANSFER MONEY";
    }
}
