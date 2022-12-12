package com.turkcell.TechnicalService.service.dtos.saleLog.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPurchaseResponse {

	private long saleLogId;	
	
	private String systemUserName;	
	
	private String productName;
	
	private double salePrice;
	
	private LocalDate purchaseDate;	
	
}
