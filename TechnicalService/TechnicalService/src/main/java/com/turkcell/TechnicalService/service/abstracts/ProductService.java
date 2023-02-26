package com.turkcell.TechnicalService.service.abstracts;

import com.turkcell.TechnicalService.model.Product;

import java.util.Locale;

public interface ProductService {

	Product getByIdAsProduct(long productId,Locale locale);
}
