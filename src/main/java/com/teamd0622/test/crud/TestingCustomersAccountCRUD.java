package com.teamd0622.test.crud;

import com.teamd0622.model.entity.CustomersAccount;
import com.teamd0622.mapper.CustomersAccountMapper;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingCustomersAccountCRUD {
    @Autowired
    CustomersAccountMapper customersAccountMapper;
    RandomGenerated rg = new RandomGenerated();
    public CustomersAccount createNewCustomerInfo(){

        CustomersAccount ca = new CustomersAccount();
        ca.setId(rg.randomInt());
        ca.setOwner(rg.randomString(10));
        ca.setBalance(rg.randomInt());
        ca.setCurrency("AED");
        return ca;
    }

    @GetMapping("/test/addCustomersAccountTesting")
    public String addCustomersAccountTesting(){
        int msg = customersAccountMapper.addCustomerAccount(createNewCustomerInfo());
        System.out.println("ADD NEW DATA>>>" + msg);
        return "\"ADD NEW DATA>>>\"";
    }

    @PostMapping("/test/updateCustomersAccountTesting")
    public String updateCustomersAccountTesting(){
        int msg = customersAccountMapper.updateCustomerAccount(createNewCustomerInfo());
        System.out.println("UPDATE NEW DATA>>>" + msg);
        return "\"UPDATE NEW DATA>>>\"";
    }

    @DeleteMapping("/test/deleteCustomersAccountByIdTesting/{id}")
    public String deleteCustomersAccountByIdTesting(@PathVariable Integer id){
        customersAccountMapper.deleteCustomerAccountById(id);
        return "DELETE";
    }

    @GetMapping("/test/getCustomersAccountByIdTesting/{id}")
    public String getCustomersAccountByIdTesting(@PathVariable Integer id){
        System.out.println(customersAccountMapper.getCustomerAccountById(id));
        return "GET ACCOUNT";
    }

    @GetMapping("/test/getCustomersAccountByIdTesting")
    public String getAllCustomersAccountTesting(){
        List<CustomersAccount> list = new ArrayList<>();
        list = customersAccountMapper.getAllCustomersAccount();
        for (CustomersAccount ca : list){
            System.out.println(ca);
        }
        return "GET ALL ACCOUNTS";
    }
}
