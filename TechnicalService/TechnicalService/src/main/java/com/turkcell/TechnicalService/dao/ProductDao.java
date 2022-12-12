package com.turkcell.TechnicalService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
