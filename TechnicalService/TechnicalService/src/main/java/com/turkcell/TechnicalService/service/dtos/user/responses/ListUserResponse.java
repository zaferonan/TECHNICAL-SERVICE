package com.turkcell.TechnicalService.service.dtos.user.responses;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserResponse {

	private long userId;

	private String username;
	
	private String role;	
	
}
