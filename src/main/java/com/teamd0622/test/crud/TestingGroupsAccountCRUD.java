package com.teamd0622.test.crud;

import com.teamd0622.model.entity.GroupsAccount;
import com.teamd0622.mapper.GroupsAccountMapper;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingGroupsAccountCRUD {
    @Autowired
    GroupsAccountMapper groupsAccountMapper;
    RandomGenerated rg = new RandomGenerated();
    public GroupsAccount createNewGroupInfo(){

        GroupsAccount ga = new GroupsAccount();
        ga.setId(rg.randomInt());
        ga.setOwner(rg.randomString(10));
        ga.setBalance(rg.randomInt());
        ga.setCurrency("AED");
        ga.setMission_vision(rg.randomString(100));
        return ga;
    }
    @GetMapping("/test/addGroupsAccountTesting")
    public String addGroupsAccountTesting(){
        int msg = groupsAccountMapper.addGroupsAccount(createNewGroupInfo());
        System.out.println("ADD NEW DATA>>>" + msg);
        return "\"ADD NEW DATA>>>\"";
    }

    @PostMapping("/test/updateGroupsAccountTesting")
    public String updateGroupsAccountTesting(){
        int msg = groupsAccountMapper.updateGroupsAccount(createNewGroupInfo());
        System.out.println("UPDATE NEW DATA>>>" + msg);
        return "\"UPDATE NEW DATA>>>\"";
    }

    @DeleteMapping("/test/deleteGroupsAccountByIdTesting/{id}")
    public String deleteGroupsAccountByIdTesting(@PathVariable Integer id){
        groupsAccountMapper.deleteGroupsAccountById(id);
        return "DELETE";
    }

    @GetMapping("/test/getGroupsAccountByIdTesting/{id}")
    public String getGroupsAccountByIdTesting(@PathVariable Integer id){
        System.out.println(groupsAccountMapper.getGroupsAccountById(id));
        return "GET ACCOUNT";
    }

    @GetMapping("/test/getGroupsAccountByIdTesting")
    public String getAllGroupsAccountTesting(){
        List<GroupsAccount> list = new ArrayList<>();
        list = groupsAccountMapper.getAllGroupsAccount();
        for (GroupsAccount ga : list){
            System.out.println(ga);
        }
        return "GET ALL ACCOUNTS";
    }
}
