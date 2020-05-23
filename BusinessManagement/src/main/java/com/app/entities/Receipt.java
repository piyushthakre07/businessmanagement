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
@Table(name ="receipt")
@Setter @Getter
public class Receipt {

	@Id
	@Column(name = "receipt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long receiptId;
	
	@Column(name="year")
	private String year;
	
	@Column(name="month")
	private String month;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "league_id")
	private Ledger ledger;
	
	@Column(name="particular")
	private String particular;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_unit_Id")
	private BusinessUnit businessUnit;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="receipt_mode")
	private String receiptMode;
	
	@Column(name="receipt_mode_details")
	private String receiptModeDetails;
	
	@OneToOne(fetch = FetchType.EAGER)
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
