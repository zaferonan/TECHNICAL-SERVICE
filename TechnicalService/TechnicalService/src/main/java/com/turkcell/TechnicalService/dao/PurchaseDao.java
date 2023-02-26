package com.turkcell.TechnicalService.dao;

import com.turkcell.TechnicalService.model.SaleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDao extends JpaRepository<SaleLog, Long> {

}
