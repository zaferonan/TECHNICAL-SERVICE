package com.turkcell.TechnicalService.service.dtos.booking.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {

	private long systemUserId;

	private long bookingServiceId;
	
	@Size(max = 300)
	private String bookingNote;
}
