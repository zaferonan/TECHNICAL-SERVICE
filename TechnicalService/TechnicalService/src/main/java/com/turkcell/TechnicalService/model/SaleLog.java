package com.turkcell.TechnicalService.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@CreatedDate
	private LocalDate purchaseDate;
	
	
	private String creditCardNumber;
}
