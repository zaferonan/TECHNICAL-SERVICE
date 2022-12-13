package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.abstracts.SaleForUserService;
import com.turkcell.TechnicalService.service.dtos.sale.responses.ListSaleResponse;
import com.turkcell.TechnicalService.service.dtos.saleLog.requests.PurchaseRequest;
import com.turkcell.TechnicalService.service.dtos.saleLog.responses.PurchaseResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class SaleForUserController {

	private final SaleForUserService saleForUserService;
	
	@PostMapping("purchaseProduct")
	public DataResult<PurchaseResponse> purchaseProduct(@Valid @RequestBody PurchaseRequest purchaseRequest,Locale locale){
		
		return saleForUserService.purchaseProduct(purchaseRequest, locale);
		
	}
	@GetMapping("/getSalesByProduct")
	public DataResult<List<ListSaleResponse>> getAllSalesByProduct(@Valid @RequestParam String productName, Locale locale){
		return saleForUserService.getAllSalesByProduct(productName, locale);
	}
}
