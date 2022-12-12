package com.turkcell.TechnicalService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.SaleLog;

@Repository
public interface PurchaseDao extends JpaRepository<SaleLog, Long> {

}
