package com.turkcell.TechnicalService.service.dtos.sale.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSaleRequest {

	@NotNull
	private long saleId;
	
	@NotNull
	private long productId;
	
	@NotNull
	private double salePrice;
	
	@NotNull
	private String saleNote;
}
