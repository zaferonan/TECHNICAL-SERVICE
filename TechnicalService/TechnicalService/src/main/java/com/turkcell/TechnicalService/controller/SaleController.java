package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.model.Sale;
import com.turkcell.TechnicalService.service.abstracts.SaleService;
import com.turkcell.TechnicalService.service.dtos.sale.requests.CreateSaleRequest;
import com.turkcell.TechnicalService.service.dtos.sale.responses.ListSaleResponse;
import com.turkcell.TechnicalService.service.dtos.sale.responses.SaleResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/sale")
@RequiredArgsConstructor
public class SaleController {

	private final SaleService saleService;
	
	@PostMapping("/save")
	public DataResult<SaleResponse> save(@Valid @RequestBody CreateSaleRequest createSaleRequest,Locale locale){
		return saleService.save(createSaleRequest, locale);
		
	}
	@GetMapping("/getAll")
	public DataResult<List<ListSaleResponse>> getAll(Locale locale){
		return saleService.getAll(locale);
	}
	@DeleteMapping("/delete")
	public DataResult<SaleResponse> delete(@Valid @RequestParam long saleId,Locale locale){
		return saleService.delete(saleId, locale);
	}
	@GetMapping("/getById")
	public Sale getById(@Valid @RequestParam long saleId) {
		return saleService.getById(saleId);
	}
	
	
}
