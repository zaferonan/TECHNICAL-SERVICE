package com.turkcell.TechnicalService.service.dtos.saleLog.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotNull;

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
