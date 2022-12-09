package com.turkcell.TechnicalService.service.dtos.booking.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBookingRequest {

	private long bookingId;
	
	private boolean isDone;
}
