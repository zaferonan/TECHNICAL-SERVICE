package com.turkcell.TechnicalService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
	
	@Enumerated(EnumType.STRING)
	private ProposalState proposalState;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime proposalDate;
}
