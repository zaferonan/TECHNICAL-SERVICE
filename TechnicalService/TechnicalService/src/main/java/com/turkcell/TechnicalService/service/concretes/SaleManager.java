package com.turkcell.TechnicalService.service.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotNull;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.core.utils.results.SuccessDataResult;
import com.turkcell.TechnicalService.dao.SaleDao;
import com.turkcell.TechnicalService.model.Sale;
import com.turkcell.TechnicalService.service.abstracts.ProductService;
import com.turkcell.TechnicalService.service.abstracts.SaleService;
import com.turkcell.TechnicalService.service.dtos.sale.requests.CreateSaleRequest;
import com.turkcell.TechnicalService.service.dtos.sale.responses.ListSaleResponse;
import com.turkcell.TechnicalService.service.dtos.sale.responses.SaleResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleManager implements SaleService {

	private final SaleDao saleDao;
	private final ProductService productService;
	private final MessageSource messageSource;

	// Admin Operation
	@Override
	public DataResult<SaleResponse> save(CreateSaleRequest createSaleRequest, Locale locale) {
		Sale sale = new Sale();
		sale.setProduct(productService.getByIdAsProduct(createSaleRequest.getProductId(), locale));
		sale.setSalePrice(createSaleRequest.getSalePrice());
		sale.setSaleNote(createSaleRequest.getSaleNote());
		sale.setSold(false);

		saleDao.save(sale);

		SaleResponse saleResponse = new SaleResponse(sale.getSaleId(), sale.getProduct().getProductId(),
				sale.getProduct().getProductName(), sale.getSalePrice(), sale.getSaleNote(), sale.isSold());

		return new SuccessDataResult<SaleResponse>(saleResponse,
				messageSource.getMessage("sale.save.success", null, locale));
	}

	// Admin Operation
	@Override
	public DataResult<List<ListSaleResponse>> getAll(Locale locale) {
		List<Sale> sales = saleDao.findAll(Sort.by("saleId").ascending());
		List<ListSaleResponse> listSaleResponses = new ArrayList<ListSaleResponse>();
		for (Sale sale : sales) {
			ListSaleResponse listSaleResponse = new ListSaleResponse();
			listSaleResponse.setSaleId(sale.getSaleId());
			listSaleResponse.setProductName(sale.getProduct().getProductName());
			listSaleResponse.setSalePrice(sale.getSalePrice());
			listSaleResponse.setSaleNote(sale.getSaleNote());

			listSaleResponses.add(listSaleResponse);
		}

		return new SuccessDataResult<List<ListSaleResponse>>(listSaleResponses,
				messageSource.getMessage("sale.getall.success", null, locale));
	}

	// Admin Operation
	@Override
	public DataResult<SaleResponse> delete(long saleId, Locale locale) {
		checkSaleIdExists(saleId, locale);

		Sale sale = saleDao.findById(saleId).get();
		SaleResponse saleResponse = new SaleResponse(sale.getSaleId(), sale.getProduct().getProductId(),
				sale.getProduct().getProductName(), sale.getSalePrice(), sale.getSaleNote(), sale.isSold());

		saleDao.deleteById(saleId);

		return new SuccessDataResult<SaleResponse>(saleResponse,
				messageSource.getMessage("sale.delete.success", null, locale));
	}


	
	private void checkSaleIdExists(long saleId, Locale locale) {
		if(!saleDao.existsById(saleId)) {
			throw new BusinessException(messageSource.getMessage("sale.checksaleidexists.error",new Object[] {saleId}, locale));
		}
		
	}

	@Override
	public void checkSaleIsSold(@NotNull long saleId, Locale locale) {
		checkSaleIdExists(saleId, locale);
		if(saleDao.findById(saleId).get().isSold()) {
			throw new BusinessException(messageSource.getMessage("sale.checksaleissold.error",new Object[] {saleId}, locale));
		}
		
	}

	@Override
	public void markAsSold(@NotNull long saleId) {
		Sale sale=saleDao.findById(saleId).get();
		sale.setSold(true);
		saleDao.save(sale);		
	}

	@Override
	public DataResult<SaleResponse> getById(@NotNull long saleId,Locale locale) {
		checkSaleIdExists(saleId, null);
		Sale sale = saleDao.findById(saleId).get();
		SaleResponse saleResponse = new SaleResponse(sale.getSaleId(), sale.getProduct().getProductId(),
				sale.getProduct().getProductName(), sale.getSalePrice(), sale.getSaleNote(), sale.isSold());
		
		return new SuccessDataResult<SaleResponse>(saleResponse,
				messageSource.getMessage("sale.getbyid.success", null, locale));
	}

	@Override
	public DataResult<List<ListSaleResponse>> getAllByProduct(String productName, Locale locale) {
		List<Sale> sales;
		if(productName!=null) {
			sales= saleDao.findAllByProductProductNameContainsIgnoreCase(productName,Sort.by("saleId").ascending());
		}else {
			sales = saleDao.findAll(Sort.by("saleId").ascending());
		}
		List<ListSaleResponse> listSaleResponses = new ArrayList<ListSaleResponse>();
		for (Sale sale : sales) {
			ListSaleResponse listSaleResponse = new ListSaleResponse();
			listSaleResponse.setSaleId(sale.getSaleId());
			listSaleResponse.setProductName(sale.getProduct().getProductName());
			listSaleResponse.setSalePrice(sale.getSalePrice());
			listSaleResponse.setSaleNote(sale.getSaleNote());

			listSaleResponses.add(listSaleResponse);
		}

		return new SuccessDataResult<List<ListSaleResponse>>(listSaleResponses,
				messageSource.getMessage("sale.getallbyproduct.success", new Object[] {productName}, locale));
	}

	@Override
	public Sale getByIdAsSale(@NotNull long saleId, Locale locale) {
		checkSaleIdExists(saleId, locale);
		return saleDao.findById(saleId).get();
	}

}
