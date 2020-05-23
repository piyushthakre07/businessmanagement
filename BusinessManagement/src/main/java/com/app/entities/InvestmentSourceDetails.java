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
@Table(name="investment_details")
public class InvestmentSourceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "investment_source_details_id", unique = true,nullable = false)
	private Long investmentSourceDetailsId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_unit_Id")
	private BusinessUnit businessUnit;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_id")
	private LoanDetails loanDetails;
	
	@Column(name="investment_date")
	private String investmentDate;
	
	@Column(name="investment_type")
	private String investmentType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="active")
	private String active;
	
	@Column(name="remark")
	private String remark;
	
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
