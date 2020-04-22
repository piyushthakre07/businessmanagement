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
@Setter
@Getter
@Table(name = "bank_details")
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id", unique = true, nullable = false)
	private Long bankId;

	@Column(name = "payee_name", length = 15)
	private String payeeName;

	@Column(name = "bank_name", length = 15)
	private String bankName;

	@Column(name = "account_number", length = 15)
	private String accountNumber;

	@Column(name = "ifsc_code", length = 10)
	private String ifscCode;

	@Column(name = "account_type", length = 10)
	private String accountType;

	@Column(name = "bank_address", length = 50)
	private String bankAddress;

	@Column(name = "active", length = 2)
	private String active;

	@Column(name = "created_by", length = 10)
	private String createdBy;

	@CreationTimestamp
	@Column(name = "created_date", length = 15)
	private Date createdDate;

	@Column(name = "modify_by", length = 10)
	private String modifyBy;

	@UpdateTimestamp
	@Column(name = "modify_date", length = 15)
	private Date modifyDate;
}
