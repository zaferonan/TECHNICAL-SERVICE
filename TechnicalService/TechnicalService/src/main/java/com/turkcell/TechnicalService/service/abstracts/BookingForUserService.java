package com.turkcell.TechnicalService.service.abstracts;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.booking.requests.CreateBookingRequest;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;
import com.turkcell.TechnicalService.service.dtos.booking.responses.ListBookingResponse;

import java.util.List;
import java.util.Locale;

public interface BookingForUserService {

	public DataResult<BookingResponse> save(CreateBookingRequest createBookingRequest,Locale locale);
	public DataResult<BookingResponse> getById(long bookingId,Locale locale);	
	public DataResult<BookingResponse> delete(long bookingId,Locale locale);
	DataResult<List<ListBookingResponse>> getAllByUser(long systemUserId, Locale locale);
	
}
