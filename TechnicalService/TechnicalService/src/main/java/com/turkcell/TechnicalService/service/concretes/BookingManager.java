package com.turkcell.TechnicalService.service.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.core.utils.results.SuccessDataResult;
import com.turkcell.TechnicalService.dao.BookingDao;
import com.turkcell.TechnicalService.model.Booking;
import com.turkcell.TechnicalService.service.abstracts.BookingService;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;
import com.turkcell.TechnicalService.service.dtos.booking.responses.ListBookingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingManager implements BookingService {

	private final BookingDao bookingDao;

	private final MessageSource messageSource;

	
	// User-Admin Operation
	@Override
	public DataResult<BookingResponse> getById(long bookingId, Locale locale) {
		checkBookingIdExists(bookingId, locale);
		Booking booking = bookingDao.findById(bookingId).get();

		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setBookingId(booking.getBookingId());
		bookingResponse.setSystemUserName(booking.getSystemUser().getName());
		bookingResponse.setBookingServiceName(booking.getBookingService().getServiceName());
		bookingResponse.setBookingNote(booking.getBookingNote());
		bookingResponse.setBookingDate(booking.getBookingDate());
		bookingResponse.setDone(booking.isDone());

		return new SuccessDataResult<BookingResponse>(bookingResponse,
				messageSource.getMessage("booking.getbyid.success", null, locale));
	}

	// Admin Operation
	@Override
	public DataResult<List<ListBookingResponse>> getAll(Sort.Direction direction, Locale locale) {
		Sort sort = Sort.by(direction, "bookingDate");
		List<Booking> bookings = bookingDao.findAll(sort);
		List<ListBookingResponse> listBookingResponses = new ArrayList<ListBookingResponse>();

		for (Booking booking : bookings) {
			ListBookingResponse listBookingResponse = new ListBookingResponse();
			listBookingResponse.setBookingId(booking.getBookingId());
			listBookingResponse.setSystemUserName(booking.getSystemUser().getName());
			listBookingResponse.setBookingServiceName(booking.getBookingService().getServiceName());
			listBookingResponse.setBookingDate(booking.getBookingDate());
			listBookingResponse.setDone(booking.isDone()); 
			
			listBookingResponses.add(listBookingResponse);
		}

		return new SuccessDataResult<List<ListBookingResponse>>(listBookingResponses,
				messageSource.getMessage("booking.getall.success", null, locale));
	}
	

	// Admin Operation
	@Override
	public DataResult<List<ListBookingResponse>> getByName(String userName, Locale locale) {
		List<Booking> bookings = bookingDao.findBySystemUserNameContainsIgnoreCase(userName);
		List<ListBookingResponse> listBookingResponses = new ArrayList<ListBookingResponse>();

		for (Booking booking : bookings) {
			ListBookingResponse listBookingResponse = new ListBookingResponse();
			listBookingResponse.setBookingId(booking.getBookingId());
			listBookingResponse.setSystemUserName(booking.getSystemUser().getName());
			listBookingResponse.setBookingServiceName(booking.getBookingService().getServiceName());
			listBookingResponse.setBookingDate(booking.getBookingDate());
			listBookingResponse.setDone(booking.isDone());
			
			listBookingResponses.add(listBookingResponse);
		}

		return new SuccessDataResult<List<ListBookingResponse>>(listBookingResponses,
				messageSource.getMessage("booking.getByName.success", null, locale));
	}

	// Admin Operation
	@Override
	public DataResult<BookingResponse> markBookingAsDone(long bookingId, Locale locale) {
		checkBookingIdExists(bookingId, locale);
		Booking booking = bookingDao.findById(bookingId).get();

		booking.setDone(true);

		bookingDao.save(booking);
		
		return new SuccessDataResult<BookingResponse>(
				new BookingResponse(booking.getBookingId(), booking.getSystemUser().getName(), booking.getBookingDate(),
						booking.getBookingService().getServiceName(), booking.getBookingNote(), booking.isDone()),
				messageSource.getMessage("booking.markbookingasdone.success", null, locale));

	}


	private void checkBookingIdExists(long bookingId, Locale locale) {
		if (!bookingDao.existsById(bookingId)) {
			throw new BusinessException(
					messageSource.getMessage("booking.checkbookingidexists.error", new Object[] {bookingId}, locale));
		}

	}

}
