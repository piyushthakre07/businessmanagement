package com.app.module.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.LoanDetails;

public interface ILoanDetailsDao extends JpaRepository<LoanDetails, Long>{

}
