package com.app.model.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Owner;

@Repository
public interface IOwnerDao extends JpaRepository<Owner, Long>

{

}
