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
import org.springframework.data.rest.core.annotation.Description;

import lombok.Getter;
import lombok.Setter;
@EnableJpaAuditing
@Entity
@Setter @Getter
@Table(name="investment_details")
public class InvestmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "investment_id", unique = true,nullable = false)
	private Long investmentId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_unit_Id")
	private BusinessUnit businessUnit;
	
	@Description("total  investment including partner")
	@Column(name="total_invest_amount")
	private Integer totalInvestAmount;
	
	@Description("total amount invest by owner")
	@Column(name="amount_invest")
	private Integer amountInvest;
	
	@Description("our own percentage")
	@Column(name="percentage")
	private Integer percentage;
	
	@Description("duration in month")
	@Column(name="duration")
	private String duration;
	
	@Description("only League who  type is investment")
	@Column(name="pay_to")
	private League payTo;
	
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
