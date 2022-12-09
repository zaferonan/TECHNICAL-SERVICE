package com.turkcell.TechnicalService.service.dtos.booking.requests;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {

	private long systemUserId;

	private long bookingServiceId;
	
	@Size(max = 300)
	private String bookingNote;
}
