package com.app.model.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.BusinessCatagory;


@Repository
public interface IBusinessCatagoryDao extends JpaRepository<BusinessCatagory, Long> {

}
