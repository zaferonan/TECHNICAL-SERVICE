package com.turkcell.TechnicalService.service.dtos.saleLog.requests;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {

	@NotNull
	private long saleId;
	@NotNull
	@CreditCardNumber
	private String creditCardNumber;
	@NotNull
	private long systemUserId;
}
