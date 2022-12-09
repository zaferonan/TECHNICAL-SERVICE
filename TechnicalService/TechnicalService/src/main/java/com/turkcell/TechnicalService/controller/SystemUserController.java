package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.abstracts.SystemUserService;
import com.turkcell.TechnicalService.service.dtos.user.requests.CreateUserRequest;
import com.turkcell.TechnicalService.service.dtos.user.requests.UpdateUserRequest;
import com.turkcell.TechnicalService.service.dtos.user.responses.ListUserResponse;
import com.turkcell.TechnicalService.service.dtos.user.responses.UserResponse;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/systemuser")
@RequiredArgsConstructor
public class SystemUserController {

	private final SystemUserService systemUserService;
	
	@GetMapping(value="getAll")
	public DataResult<List<ListUserResponse>> getAll(Locale locale) {
		return systemUserService.getAll(locale);
	}
	
	@PostMapping("/save")
	public DataResult<UserResponse> save(@Valid @RequestBody CreateUserRequest createUserRequest,Locale locale){
		return systemUserService.save(createUserRequest, locale);
		
	}
	@DeleteMapping("/delete")
	public DataResult<UserResponse> delete(@RequestParam long systemUserId,Locale locale) {
		return systemUserService.delete(systemUserId, locale);
	}
	
	@PutMapping("/update")
	public DataResult<UserResponse> update(@Valid @RequestBody UpdateUserRequest updateUserRequest, Locale locale) {
		return systemUserService.update(updateUserRequest, locale);
	}
	
	@GetMapping("/getById")
	public DataResult<UserResponse> getById(@RequestParam long systemUserId, Locale locale){
		return systemUserService.getById(systemUserId, locale);
	}
	
	@GetMapping("/getByRole")
	public DataResult<List<ListUserResponse>> getByRole(@RequestParam String role, Locale locale){
		return systemUserService.getByRole(role, locale);
	}
	
	
}
