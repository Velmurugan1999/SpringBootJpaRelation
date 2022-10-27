package com.relation.onetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relation.models.MedicalShop;

@Repository
public interface MedicalShopDao extends JpaRepository<MedicalShop, Integer>{

}
