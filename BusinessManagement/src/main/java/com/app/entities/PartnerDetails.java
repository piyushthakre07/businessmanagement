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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "partner_details")
public class PartnerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_details_id", unique = true, nullable = false)
	private Long partnerDetailsId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_unit_Id")
	private BusinessUnit businessUnit;
	
	@Column(name = "partner_name")
	private String partnerName;
	
	@Column(name="partner_contact_number")
	private String partnerContactNumber;
	
	@Column(name="partner_address")
	private String partnerAddress;
	
	@Column(name="partner_amount_invest")
	private Integer partnerAmountInvest;
	
	@Column(name="partner_percentage")
	private Integer partnerPercentage;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="description")
	private String description;
	
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
