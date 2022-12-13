package com.turkcell.TechnicalService.service.dtos.saleLog.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "dd.MM.yyyy - HH:mm")
	private LocalDateTime purchaseDate;	
	
}
