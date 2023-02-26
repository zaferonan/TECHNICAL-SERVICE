package com.turkcell.TechnicalService.dao;

import com.turkcell.TechnicalService.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemUserDao extends JpaRepository<SystemUser, Long> {

	boolean existsByName(String username);

	boolean existsByMail(String userMail);

	List<SystemUser> findByRolesRoleName(String roleName);
	
	public SystemUser findByName(String userName);

}
