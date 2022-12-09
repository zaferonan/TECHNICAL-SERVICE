package com.turkcell.TechnicalService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Service;

@Repository
public interface ServiceDao extends JpaRepository<Service, Long> {

}
