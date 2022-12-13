package com.turkcell.TechnicalService.service.dtos.sale.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSaleResponse {

	private long saleId;
	
	
	private String productName;
	
	
	private double salePrice;
	
	
	private String saleNote;
	
	private boolean isSold;
}
