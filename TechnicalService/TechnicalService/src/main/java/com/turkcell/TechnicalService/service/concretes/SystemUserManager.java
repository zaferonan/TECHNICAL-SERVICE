package com.turkcell.TechnicalService.service.concretes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.core.utils.results.SuccessDataResult;
import com.turkcell.TechnicalService.dao.SystemUserDao;
import com.turkcell.TechnicalService.model.Role;
import com.turkcell.TechnicalService.model.SystemUser;
import com.turkcell.TechnicalService.service.abstracts.SystemUserService;
import com.turkcell.TechnicalService.service.dtos.user.requests.CreateUserRequest;
import com.turkcell.TechnicalService.service.dtos.user.requests.UpdateUserRequest;
import com.turkcell.TechnicalService.service.dtos.user.responses.ListUserResponse;
import com.turkcell.TechnicalService.service.dtos.user.responses.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemUserManager implements SystemUserService {

	private final SystemUserDao systemUserDao;
	private final MessageSource messageSource;

	@Override
	public DataResult<List<ListUserResponse>> getAll(Locale locale) {
		List<SystemUser> systemUsers = systemUserDao.findAll();

		List<ListUserResponse> listUserResponses = new ArrayList<ListUserResponse>();

		for (SystemUser systemUser : systemUsers) {
			ListUserResponse listUserResponse = new ListUserResponse(systemUser.getSystemUserId(), systemUser.getName(),
					systemUser.getRoles().get(0).getRoleName());
			listUserResponses.add(listUserResponse);
		}

		return new SuccessDataResult<List<ListUserResponse>>(listUserResponses,
				messageSource.getMessage("systemuser.getall.success", null, locale));
	}

	@Override
	public DataResult<UserResponse> save(CreateUserRequest createUserRequest, Locale locale) {
		checkUserMailExists(createUserRequest.getUserMail(), locale);
		checkUserNameExists(createUserRequest.getUsername(), locale);

		SystemUser systemUser = new SystemUser();
		systemUser.setName(createUserRequest.getUsername());
		systemUser.setPassword(createUserRequest.getUserPassword());
		systemUser.setMail(createUserRequest.getUserMail());
		systemUser.setRoles(Arrays.asList(new Role(2, "ROLE_USER")));

		systemUserDao.save(systemUser);

		UserResponse userResponse = new UserResponse(systemUser.getSystemUserId(), systemUser.getName(),
				systemUser.getMail(), systemUser.getRoles().get(0).getRoleName());

		return new SuccessDataResult<UserResponse>(userResponse,
				messageSource.getMessage("systemuser.save.success", null, locale));
	}

	@Override
	public DataResult<UserResponse> delete(long systemUserId, Locale locale) {

		UserResponse userResponse = this.getById(systemUserId, locale).getData();

		systemUserDao.deleteById(systemUserId);

		return new SuccessDataResult<UserResponse>(userResponse,
				messageSource.getMessage("systemuser.delete.success", null, locale));
	}

	@Override
	public DataResult<UserResponse> update(UpdateUserRequest updateUserRequest, Locale locale) {
		checkUserIdExists(updateUserRequest.getUserId(), locale);

		SystemUser systemUser = new SystemUser();
		systemUser.setSystemUserId(updateUserRequest.getUserId());
		systemUser.setName(updateUserRequest.getUsername());
		systemUser.setPassword(updateUserRequest.getUserPassword());
		systemUser.setMail(updateUserRequest.getUserMail());

		systemUserDao.save(systemUser);

		UserResponse userResponse = new UserResponse(systemUser.getSystemUserId(), systemUser.getName(),
				systemUser.getMail(), systemUser.getRoles().get(0).getRoleName());

		return new SuccessDataResult<UserResponse>(userResponse,
				messageSource.getMessage("systemuser.update.success", null, locale));
	}

	@Override
	public DataResult<UserResponse> getById(long systemUserId, Locale locale) {
		checkUserIdExists(systemUserId, locale);
		SystemUser systemUser = systemUserDao.findById(systemUserId).get();
		UserResponse userResponse = new UserResponse(systemUserId, systemUser.getName(), systemUser.getMail(),
				systemUser.getRoles().get(0).getRoleName());
		return new SuccessDataResult<UserResponse>(userResponse,
				messageSource.getMessage("systemuser.getById.success", null, locale));
	}

	@Override
	public DataResult<List<ListUserResponse>> getByRole(String role, Locale locale) {
		List<SystemUser> systemUsers = systemUserDao.findByRolesRoleName(role);

		List<ListUserResponse> listUserResponses = new ArrayList<ListUserResponse>();

		for (SystemUser systemUser : systemUsers) {
			ListUserResponse listUserResponse = new ListUserResponse(systemUser.getSystemUserId(), systemUser.getName(),
					systemUser.getRoles().get(0).getRoleName());
			listUserResponses.add(listUserResponse);
		}

		return new SuccessDataResult<List<ListUserResponse>>(listUserResponses,
				messageSource.getMessage("systemuser.getall.success", null, locale));
	}

	private void checkUserNameExists(String username, Locale locale) {
		if (systemUserDao.existsByName(username)) {
			throw new BusinessException(messageSource.getMessage("systemuser.checkusername.error", null, locale));
		}

	}

	private void checkUserMailExists(String userMail, Locale locale) {
		if (systemUserDao.existsByMail(userMail)) {
			throw new BusinessException(messageSource.getMessage("systemuser.checkusermail.error", null, locale));
		}

	}

	private void checkUserIdExists(long systemUserId, Locale locale) {
		if (!systemUserDao.existsById(systemUserId)) {
			throw new BusinessException(
					messageSource.getMessage("systemuser.checkuserid.error", null, locale) + " " + systemUserId);
		}

	}

	@Override
	public SystemUser getByIdAsUser(long systemUserId, Locale locale) {
		checkUserIdExists(systemUserId, locale);
		return systemUserDao.findById(systemUserId).get();
	}
}
