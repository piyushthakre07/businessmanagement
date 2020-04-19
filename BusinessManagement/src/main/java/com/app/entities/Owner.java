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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "owner_master")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "owner_id", unique = true, nullable = false)
	private Long ownerId;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "active")
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
