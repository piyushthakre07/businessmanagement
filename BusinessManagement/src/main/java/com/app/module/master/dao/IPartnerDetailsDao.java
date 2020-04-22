package com.app.module.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.PartnerDetails;

@Repository
public interface IPartnerDetailsDao extends JpaRepository<PartnerDetails, Long> {

}
