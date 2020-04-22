package com.app.module.master.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Payment;

@Repository
public interface IPaymentDao extends JpaRepository<Payment, Long> {

}
