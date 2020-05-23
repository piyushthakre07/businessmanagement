package com.app.module.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.InvestmentDetails;

@Repository
public interface IInvestmentDetailsDao extends JpaRepository<InvestmentDetails,Long>{

}
