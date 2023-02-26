package com.turkcell.TechnicalService.service.abstracts;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.sale.responses.ListSaleResponse;
import com.turkcell.TechnicalService.service.dtos.saleLog.requests.PurchaseRequest;
import com.turkcell.TechnicalService.service.dtos.saleLog.responses.PurchaseResponse;

import java.util.List;
import java.util.Locale;

public interface SaleForUserService {

	public DataResult<PurchaseResponse> purchaseProduct(PurchaseRequest purchaseRequest,Locale locale);
	public DataResult<List<ListSaleResponse>> getAllSalesByProduct(String productName, Locale locale);
}
