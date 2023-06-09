package com.teamd0622.mapper;

import com.teamd0622.model.entity.CustomersAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomersAccountMapper {
    int addCustomerAccount(CustomersAccount customersAccount);
    int updateCustomerAccount(CustomersAccount customersAccount);
    int deleteCustomerAccountById(Integer id);
    CustomersAccount getCustomerAccountById(Integer id);
    List<CustomersAccount> getAllCustomersAccount();
}
