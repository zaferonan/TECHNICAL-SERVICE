package com.turkcell.TechnicalService.service.concretes;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.dao.ProductDao;
import com.turkcell.TechnicalService.model.Product;
import com.turkcell.TechnicalService.service.abstracts.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

	private final ProductDao productDao;
	private final MessageSource messageSource;

	@Override
	public Product getByIdAsProduct(long productId, Locale locale) {
		checkProductIdExists(productId, locale);

		return productDao.findById(productId).get();
	}

	private void checkProductIdExists(long productId, Locale locale) {
		if (!productDao.existsById(productId)) {
			throw new BusinessException(
					messageSource.getMessage("product.checkproductidexists.error", null, locale) + " " + productId);
		}

	}
}
