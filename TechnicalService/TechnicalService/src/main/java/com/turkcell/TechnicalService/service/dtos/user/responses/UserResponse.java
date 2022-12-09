package com.turkcell.TechnicalService.service.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private long userId;	

	private String username;
	
	private String userMail;
	
	private String role;
}
