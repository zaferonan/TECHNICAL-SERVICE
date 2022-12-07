package com.turkcell.TechnicalService.service.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private int userId;
	

	private String username;


	private String userNameSurname;
	
	
	private String userMail;
}
