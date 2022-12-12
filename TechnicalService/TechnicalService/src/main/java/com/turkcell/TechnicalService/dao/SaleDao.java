package com.turkcell.TechnicalService.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.TechnicalService.model.Sale;

public interface SaleDao extends JpaRepository<Sale	, Long> {

	List<Sale> findAllByProductProductNameContainsIgnoreCase(String productName, Sort direction);

}
