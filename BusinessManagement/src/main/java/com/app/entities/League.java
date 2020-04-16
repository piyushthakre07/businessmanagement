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
@Table(name="league")
public class League {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "league_id", unique = true,nullable = false)
	private Long leagueId;
	
	@Column(name="league_name")
	private String leagueName;
	
	@Column(name="league_type")
	private Integer leagueType;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_id")
	private BankDetails bankDetails;
	
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