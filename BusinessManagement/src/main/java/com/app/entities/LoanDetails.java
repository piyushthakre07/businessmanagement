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
@Table(name="loan_details")
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id", unique = true,nullable = false)
	private Long loanId;
	
	@Column(name="loan_title")
	private String loanTitle;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ledger_id")
	private Ledger loanFromLeadger;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	private BankDetails loanReceiveIntoBank;
	
	@Column(name="loan_amount")
	private Long loanAmount;
	
	@Column(name="tenure")
	private Integer tenure;
	
	@Description("Monthly or Yearly")
	@Column(name="installment_frequency")
	private String installmentFrequency;
	
	@Column(name="rate_of_interest")
	private Integer rateOfInterest;

	@Description("Total Interest Paid")
	@Column(name="total_interest_paid_amount")
	private Long totalInterestPaid;
	
	@Column(name="emi_amount_per_month")
	private Long emiAmountPerMonth;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="emi_start_date")
	private String emiStartDate;
	
	@Description("emi paid day of month")
	@Column(name="due_on")
	private Integer dueOn;
	
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
