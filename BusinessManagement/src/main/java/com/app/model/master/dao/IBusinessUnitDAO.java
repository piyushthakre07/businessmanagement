package com.app.model.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.BusinessUnit;


@Repository
public interface IBusinessUnitDAO extends JpaRepository<BusinessUnit,Long>{
	
}
