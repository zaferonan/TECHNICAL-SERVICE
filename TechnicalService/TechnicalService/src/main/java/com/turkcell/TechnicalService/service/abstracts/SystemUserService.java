package com.turkcell.TechnicalService.service.abstracts;

import java.util.List;
import java.util.Locale;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.model.SystemUser;
import com.turkcell.TechnicalService.service.dtos.user.requests.CreateUserRequest;
import com.turkcell.TechnicalService.service.dtos.user.requests.UpdateUserRequest;
import com.turkcell.TechnicalService.service.dtos.user.responses.ListUserResponse;
import com.turkcell.TechnicalService.service.dtos.user.responses.UserResponse;

public interface SystemUserService {

	public DataResult<List<ListUserResponse>> getAll(Locale locale);
	public DataResult<UserResponse>  save(CreateUserRequest createUserRequest,Locale locale);
	public DataResult<UserResponse>  delete(long systemUserId,Locale locale);
	public DataResult<UserResponse>  update(UpdateUserRequest updateUserRequest,Locale locale);
	public DataResult<UserResponse> getById(long systemUserId,Locale locale);
	public DataResult<List<ListUserResponse>> getByRole(String role,Locale locale);
	public SystemUser getByIdAsUser(long systemUserId,Locale locale);
	
}
