package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Getter;
import lombok.Setter;
@EnableJpaAuditing
@Entity
@Setter @Getter
@Table(name="business_catagory")
public class BusinessCatagory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "businessCatagory_id", unique = true,nullable = false)
	private Long businessCatagoryId;
	
	@Column(name="businessCatagory_name"  , length = 10)
	private String businessCatagoryName;
	
	@Column(name="businessCatagory_Description"  , length = 50)
	private String businessCatagoryDescription;
	
	@Column(name="active"  , length = 2)
	private String active;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@Column(name = "created_by"  , length = 10)
	private String createdBy;

	@CreationTimestamp
	@Column(name = "created_date"  , length = 15)
	private Date createdDate;
	
	@Column(name = "modify_by"  , length = 10)
	private String modifyBy;
	
	@UpdateTimestamp
	@Column(name = "modify_date"  , length = 15)
	private Date modifyDate;
}
