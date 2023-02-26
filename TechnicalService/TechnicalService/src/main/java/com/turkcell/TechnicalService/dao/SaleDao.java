package com.turkcell.TechnicalService.dao;

import com.turkcell.TechnicalService.model.Sale;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleDao extends JpaRepository<Sale	, Long> {

	List<Sale> findAllByProductProductNameContainsIgnoreCase(String productName, Sort direction);

	List<Sale> findAllByProductProductNameContainsIgnoreCaseAndIsSold(String productName, boolean b, Sort ascending);

	List<Sale> findAllByIsSold(boolean b, Sort ascending);

}
