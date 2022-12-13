package com.turkcell.TechnicalService.service.dtos.booking.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

	private long bookingId;	
	
	private String systemUserName;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate bookingDate;	
		
	private String bookingServiceName;	
	
	private String bookingNote;
	
	private boolean isDone;
}
