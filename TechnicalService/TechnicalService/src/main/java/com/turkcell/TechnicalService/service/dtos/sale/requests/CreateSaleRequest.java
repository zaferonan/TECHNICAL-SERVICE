package com.turkcell.TechnicalService.service.dtos.sale.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleRequest {


	@NotNull
	private long productId;
	
	@NotNull
	private double salePrice;
	
	@NotNull
	@Size(min=5,max=300)
	private String saleNote;
}
