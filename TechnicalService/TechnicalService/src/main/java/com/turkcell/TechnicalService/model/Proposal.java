package com.turkcell.TechnicalService.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long proposalId;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "systemUser_id")
	private SystemUser systemUser;	
	
	private double proposalPrice;
	
	@Column(length = 300)
	private String proposalNote;
	
	@Column(insertable = false,updatable = true)
	private ProposalState proposalState;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDate proposalDate;
}
