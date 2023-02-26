package com.turkcell.TechnicalService.dao;

import com.turkcell.TechnicalService.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDao extends JpaRepository<Service, Long> {

}
