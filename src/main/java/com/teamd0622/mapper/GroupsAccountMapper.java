package com.teamd0622.mapper;

import com.teamd0622.model.entity.GroupsAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupsAccountMapper {
    int addGroupsAccount(GroupsAccount groupsAccount);
    int updateGroupsAccount(GroupsAccount groupsAccount);
    int deleteGroupsAccountById(Integer id);
    GroupsAccount getGroupsAccountById(Integer id);
    List<GroupsAccount> getAllGroupsAccount();
}
