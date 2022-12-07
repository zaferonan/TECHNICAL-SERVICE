package com.turkcell.TechnicalService.service.dtos.user.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

	@NotNull
	private int userId;
	
	@Size(max = 50)
	@NotBlank
	private String username;
	
	@Size(max = 50)
	@NotBlank
	private String userPassword;
	
	@Size(max = 100)
	@NotBlank
	private String userNameSurname;
	
	@Email
	@Size(max = 50)	
	private String userMail;
	
	
}
