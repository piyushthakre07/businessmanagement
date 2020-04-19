package com.app.module.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.BankDetails;

@Repository
public interface IBankDetailsDao extends JpaRepository<BankDetails,Long> {

}
