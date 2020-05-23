package com.app.module.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Ledger;

@Repository
public interface ILedgerDao extends JpaRepository<Ledger,Long>{

}
