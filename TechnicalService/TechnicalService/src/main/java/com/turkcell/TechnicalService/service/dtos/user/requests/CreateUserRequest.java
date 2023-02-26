package com.turkcell.TechnicalService.service.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


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

}
