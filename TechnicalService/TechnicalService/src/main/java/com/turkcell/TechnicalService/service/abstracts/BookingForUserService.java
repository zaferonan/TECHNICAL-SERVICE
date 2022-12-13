package com.turkcell.TechnicalService.service.abstracts;

import java.util.Locale;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.booking.requests.CreateBookingRequest;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;

public interface BookingForUserService {

	public DataResult<BookingResponse> save(CreateBookingRequest createBookingRequest,Locale locale);
	public DataResult<BookingResponse> getById(long bookingId,Locale locale);	
	public DataResult<BookingResponse> delete(long bookingId,Locale locale);
	
}
