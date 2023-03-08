package com.teamd0622.test.crud;

import com.teamd0622.entity.CustomersAccount;
import com.teamd0622.entity.GroupsAccount;
import com.teamd0622.mapper.GroupsAccountMapper;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;

public class TestingGroupsAccountCRUD {
    @Autowired
    GroupsAccountMapper groupsAccountMapper;
    RandomGenerated rg = new RandomGenerated();
    public CustomersAccount createNewCustomerInfo(){

        GroupsAccount ga = new GroupsAccount();
        ga.setId(rg.randomInt());
        ga.setOwner(rg.randomString(10));
        ga.setBalance(rg.randomInt());
        ga.setCurrency("AED");
        ga.setMission_vision(rg.randomString(100));
        return ga;
    }
}
