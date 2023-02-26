package com.turkcell.TechnicalService.service.abstracts;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;
import com.turkcell.TechnicalService.service.dtos.booking.responses.ListBookingResponse;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Locale;

public interface BookingService {

	
	public DataResult<BookingResponse> getById(long bookingId,Locale locale);
	public DataResult<List<ListBookingResponse>> getAll(Sort.Direction direction,Locale locale);	
	public DataResult<List<ListBookingResponse>> getByName(String userName,Locale locale);
	public DataResult<BookingResponse> markBookingAsDone(long bookingId,Locale locale);
}
