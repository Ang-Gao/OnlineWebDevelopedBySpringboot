package com.teamd0622.test.crud;

import com.teamd0622.entity.CustomersAccount;
import com.teamd0622.mapper.CustomersAccountMapper;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;

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

}
