package com.turkcell.TechnicalService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.SystemUser;

@Repository
public interface SystemUserDao extends JpaRepository<SystemUser, Integer> {

}
