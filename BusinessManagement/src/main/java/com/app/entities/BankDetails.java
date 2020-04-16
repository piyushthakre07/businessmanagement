package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Getter;
import lombok.Setter;
@EnableJpaAuditing
@Entity
@Setter @Getter
@Table(name="bank_details")
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id", unique = true,nullable = false)
	private Long bankId;
	
	@Column(name="payee_name")
	private String payeeName;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="account_number")
	private Integer accountNumber;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="bank_address")
	private String bankAddress;
	
	@Column(name="active")
	private String active;
	
	@Column(name = "created_by")
	private String createdBy;

	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "modify_by")
	private String modifyBy;
	
	@UpdateTimestamp
	@Column(name = "modify_date")
	private Date modifyDate;
}
