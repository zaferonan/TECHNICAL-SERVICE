package com.turkcell.TechnicalService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.SystemUser;

@Repository
public interface SystemUserDao extends JpaRepository<SystemUser, Long> {

	boolean existsByName(String username);

	boolean existsByMail(String userMail);

	List<SystemUser> findByRolesRoleName(String roleName);
	
	public SystemUser findByName(String userName);

}
