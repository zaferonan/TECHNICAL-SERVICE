package com.turkcell.TechnicalService.service.abstracts;

import java.util.Locale;

import com.turkcell.TechnicalService.model.Product;

public interface ProductService {

	Product getByIdAsProduct(long productId,Locale locale);
}
