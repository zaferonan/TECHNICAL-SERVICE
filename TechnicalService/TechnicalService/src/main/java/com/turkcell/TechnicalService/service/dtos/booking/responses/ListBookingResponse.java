package com.turkcell.TechnicalService.service.dtos.booking.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ListBookingResponse {

	private long bookingId;	
	
	private String systemUserName;
	
	private String bookingServiceName;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate bookingDate;
	
	private boolean isDone;
	
	
	
	
	
	
}
