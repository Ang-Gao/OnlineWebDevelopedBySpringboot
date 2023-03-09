package com.teamd0622.mapper;

import com.teamd0622.model.entity.DonatedEntities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonatedEntitiesMapper {
    int addDonatedEntity(DonatedEntities donatedEntities);
    int updateDonatedEntity(DonatedEntities donatedEntities);
    int deleteDonatedEntityById(Integer id);
    DonatedEntities getDonatedEntitiesById(Integer id);
    List<DonatedEntities> getAllDonatedEntities();

}
