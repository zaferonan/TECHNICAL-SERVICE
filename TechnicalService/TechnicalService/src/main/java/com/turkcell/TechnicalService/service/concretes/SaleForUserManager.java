package com.turkcell.TechnicalService.service.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.core.utils.results.SuccessDataResult;
import com.turkcell.TechnicalService.dao.PurchaseDao;
import com.turkcell.TechnicalService.model.Sale;
import com.turkcell.TechnicalService.model.SaleLog;
import com.turkcell.TechnicalService.model.SystemUser;
import com.turkcell.TechnicalService.service.abstracts.SaleForUserService;
import com.turkcell.TechnicalService.service.abstracts.SaleService;
import com.turkcell.TechnicalService.service.abstracts.SystemUserService;
import com.turkcell.TechnicalService.service.dtos.sale.responses.ListSaleResponse;
import com.turkcell.TechnicalService.service.dtos.saleLog.requests.PurchaseRequest;
import com.turkcell.TechnicalService.service.dtos.saleLog.responses.PurchaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleForUserManager implements SaleForUserService {

	private final PurchaseDao purchaseDao;
	private final SaleService saleService;
	private final SystemUserService systemUserService;
	private final MessageSource messageSource;

	// User Operation
	@Override
	public DataResult<PurchaseResponse> purchaseProduct(PurchaseRequest purchaseRequest, Locale locale) {
		saleService.checkSaleIsSold(purchaseRequest.getSaleId(), locale);
		saleService.markAsSold(purchaseRequest.getSaleId());

		Sale sale = saleService.getByIdAsSale(purchaseRequest.getSaleId(),locale);
		SystemUser systemUser = systemUserService.getByIdAsUser(purchaseRequest.getSystemUserId(), locale);
		SaleLog saleLog = new SaleLog();
		saleLog.setSale(sale);
		saleLog.setCreditCardNumber(purchaseRequest.getCreditCardNumber());
		saleLog.setSystemUser(systemUser);
		purchaseDao.save(saleLog);

		PurchaseResponse purchaseResponse = new PurchaseResponse();
		purchaseResponse.setSaleLogId(saleLog.getSaleLogId());
		purchaseResponse.setSaleId(saleLog.getSale().getSaleId());
		purchaseResponse.setProductName(saleLog.getSale().getProduct().getProductName());
		purchaseResponse.setSystemUserId(saleLog.getSystemUser().getSystemUserId());
		purchaseResponse.setSystemUserName(saleLog.getSystemUser().getName());
		purchaseResponse.setPurchaseDate(saleLog.getPurchaseDate());
		purchaseResponse.setCreditCardNumber(saleLog.getCreditCardNumber());

		return new SuccessDataResult<PurchaseResponse>(purchaseResponse,
				messageSource.getMessage("purchase.purchaseproduct.success", null, locale));
	}

	// User Operation
	@Override
	public DataResult<List<ListSaleResponse>> getAllSalesByProduct(String productName, Locale locale) {
		
		return saleService.getAllByProduct(productName, locale);
	}
}
