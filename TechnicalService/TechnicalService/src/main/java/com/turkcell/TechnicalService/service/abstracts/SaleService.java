package com.turkcell.TechnicalService.service.abstracts;

import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotNull;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.model.Sale;
import com.turkcell.TechnicalService.service.dtos.sale.requests.CreateSaleRequest;
import com.turkcell.TechnicalService.service.dtos.sale.responses.ListSaleResponse;
import com.turkcell.TechnicalService.service.dtos.sale.responses.SaleResponse;

public interface SaleService {

	public DataResult<SaleResponse> save(CreateSaleRequest createSaleRequest,Locale locale);
	public DataResult<List<ListSaleResponse>> getAll(Locale locale);
	public DataResult<SaleResponse> delete(long saleId,Locale locale);
	public void checkSaleIsSold(@NotNull long saleId, Locale locale);
	public void markAsSold(@NotNull long saleId);	
	public DataResult<List<ListSaleResponse>> getAllByProduct(String productName,Locale locale);
	public DataResult<List<ListSaleResponse>> getAllByProductForUser(String productName,Locale locale);
	public DataResult<SaleResponse> getById(@NotNull long saleId, Locale locale);
	public Sale getByIdAsSale(@NotNull long saleId, Locale locale);
	
	
}
