package com.turkcell.TechnicalService.service.dtos.user.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

	@Size(max = 50)
	@NotBlank
	private String username;
	
	@Size(max = 50)
	@NotBlank
	private String userPassword;
	
	@Email
	@Size(max = 50)	
	private String userMail;
	
	@Size(max = 100)
	@NotBlank
	private String userNameSurname;
}
