package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Getter;
import lombok.Setter;

@EnableJpaAuditing
@Entity
@Table(name = "business_unit")
@Setter
@Getter
public class BusinessUnit {

	@Id
	@Column(name = "business_unit_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessUnitID;

	@Column(name = "unit_name")
	private String unitName;

	@Column(name = "address")
	private String address;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private String active;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "businessCatagory_id")
	private BusinessCatagory businessCatagory;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_id")
	private BankDetails bankDetails;

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
