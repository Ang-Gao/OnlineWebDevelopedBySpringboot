package com.teamd0622.test.crud;

import com.teamd0622.mapper.DonatedEntitiesMapper;
import com.teamd0622.model.entity.DonatedEntities;
import com.teamd0622.util.RandomGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingDonatedEntitiesCRUD {
    @Autowired
    DonatedEntitiesMapper donatedEntitiesMapper;
    RandomGenerated rg = new RandomGenerated();
    public DonatedEntities createNewDonatedEntity(){
        DonatedEntities donatedEntity = new DonatedEntities();
        donatedEntity.setId(rg.randomInt());
        donatedEntity.setFrom_account_id(rg.randomInt());
        donatedEntity.setDelivery_status(rg.randomString(15));
        return donatedEntity;
    }

    @GetMapping("/test/addDonatedEntitiesTesting")
    public String addDonatedEntitiesTesting(){
        int msg = donatedEntitiesMapper.addDonatedEntity(createNewDonatedEntity());
        System.out.println("ADD NEW DATA>>>" + msg);
        return "\"ADD NEW DATA>>>\"";
    }

    @PostMapping("/test/updateDonatedEntitiesTesting")
    public String updateDonatedEntitiesTesting(){
        int msg = donatedEntitiesMapper.updateDonatedEntity(createNewDonatedEntity());
        System.out.println("UPDATE NEW DATA>>>" + msg);
        return "\"UPDATE NEW DATA>>>\"";
    }

    @DeleteMapping("/test/deleteDonatedEntitiesByIdTesting/{id}")
    public String deleteDonatedEntitiesByIdTesting(@PathVariable Integer id){
        donatedEntitiesMapper.deleteDonatedEntityById(id);
        return "DELETE";
    }

    @GetMapping("/test/getDonatedEntitiesByIdTesting/{id}")
    public String getDonatedEntitiesByIdTesting(@PathVariable Integer id){
        System.out.println(donatedEntitiesMapper.getDonatedEntitiesById(id));
        return "GET DONATED ENTITY";
    }

    @GetMapping("/test/getAllDonatedEntitiesTesting")
    public String getAllDonatedEntitiesTesting(){
        List<DonatedEntities> list = new ArrayList<>();
        list = donatedEntitiesMapper.getAllDonatedEntities();
        for (DonatedEntities de : list){
            System.out.println(de);
        }
        return "GET ALL DONATED ENTITIES";
    }
}
