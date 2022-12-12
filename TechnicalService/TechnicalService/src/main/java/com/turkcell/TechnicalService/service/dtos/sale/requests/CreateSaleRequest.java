package com.turkcell.TechnicalService.service.dtos.sale.requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleRequest {


	@NotNull
	private long productId;
	
	@NotNull
	private double salePrice;
	
	@NotNull
	private String saleNote;
}
