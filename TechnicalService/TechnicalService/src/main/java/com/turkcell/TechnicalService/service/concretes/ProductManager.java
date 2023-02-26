package com.turkcell.TechnicalService.service.concretes;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.dao.ProductDao;
import com.turkcell.TechnicalService.model.Product;
import com.turkcell.TechnicalService.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

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
					messageSource.getMessage("product.checkproductidexists.error", new Object[] {productId}, locale));
		}

	}
}
