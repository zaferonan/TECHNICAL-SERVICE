package com.turkcell.TechnicalService.service.dtos.booking.responses;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

	private long bookingId;	
	
	private String systemUserName;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate bookingDate;	
		
	private String bookingServiceName;	
	
	private String bookingNote;
	
	private boolean isDone;
}
