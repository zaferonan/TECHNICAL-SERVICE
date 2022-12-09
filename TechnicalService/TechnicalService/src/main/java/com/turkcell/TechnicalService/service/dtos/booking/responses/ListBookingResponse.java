package com.turkcell.TechnicalService.service.dtos.booking.responses;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ListBookingResponse {

	private long bookingId;	
	
	private String systemUserName;
	
	private String bookingServiceName;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate bookingDate;
	
	
	
	
	
	
}
