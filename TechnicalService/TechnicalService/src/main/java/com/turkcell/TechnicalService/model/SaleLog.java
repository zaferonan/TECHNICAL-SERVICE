package com.turkcell.TechnicalService.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SaleLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long saleLogId;
	
	@ManyToOne
	@JoinColumn(name = "systemUser_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SystemUser systemUser;
	
	@OneToOne()
	@JoinColumn(name = "sale_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Sale sale;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime purchaseDate;
	
	
	private String creditCardNumber;
}
