package com.app.module.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Receipt;

@Repository
public interface IReceiptDao extends JpaRepository<Receipt,Long> {

}
