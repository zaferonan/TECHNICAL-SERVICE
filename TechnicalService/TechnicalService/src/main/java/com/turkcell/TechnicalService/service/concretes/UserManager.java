package com.turkcell.TechnicalService.service.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.dao.SystemUserDao;
import com.turkcell.TechnicalService.model.SystemUser;
import com.turkcell.TechnicalService.service.abstracts.UserService;
import com.turkcell.TechnicalService.service.dtos.user.responses.ListUserResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private SystemUserDao systemUserDao;

	@Override
	public DataResult<List<ListUserResponse>> getAll() {
		List<SystemUser> systemUsers=systemUserDao.findAll();
		return null;
	}
}
