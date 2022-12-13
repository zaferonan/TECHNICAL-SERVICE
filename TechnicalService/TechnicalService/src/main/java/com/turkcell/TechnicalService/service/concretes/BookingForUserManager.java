package com.turkcell.TechnicalService.service.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.core.utils.results.ErrorDataResult;
import com.turkcell.TechnicalService.core.utils.results.SuccessDataResult;
import com.turkcell.TechnicalService.dao.BookingDao;
import com.turkcell.TechnicalService.model.Booking;
import com.turkcell.TechnicalService.service.abstracts.BookingForUserService;
import com.turkcell.TechnicalService.service.abstracts.ServiceService;
import com.turkcell.TechnicalService.service.abstracts.SystemUserService;
import com.turkcell.TechnicalService.service.dtos.booking.requests.CreateBookingRequest;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingForUserManager implements BookingForUserService {

	private final BookingDao bookingDao;
	private final ServiceService serviceService;
	private final SystemUserService systemUserService;
	private final MessageSource messageSource;

	// User Operation
	@Override
	public DataResult<BookingResponse> save(CreateBookingRequest createBookingRequest, Locale locale) {

		Booking booking = new Booking();
		booking.setSystemUser(systemUserService.getByIdAsUser(createBookingRequest.getSystemUserId(), locale));
		booking.setBookingService(serviceService.getByIdAsService(createBookingRequest.getBookingServiceId(), locale));
		booking.setBookingNote(createBookingRequest.getBookingNote());
		booking.setBookingDate(this.createBookingDate(serviceService
				.getByIdAsService(createBookingRequest.getBookingServiceId(), locale).getServiceDuration()));
		booking.setDone(false);

		bookingDao.save(booking);

		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setBookingId(booking.getBookingId());
		bookingResponse.setSystemUserName(booking.getSystemUser().getName());
		bookingResponse.setBookingServiceName(booking.getBookingService().getServiceName());
		bookingResponse.setBookingNote(booking.getBookingNote());
		bookingResponse.setBookingDate(booking.getBookingDate());
		bookingResponse.setDone(false);

		return new SuccessDataResult<BookingResponse>(bookingResponse,
				messageSource.getMessage("booking.createBooking.success", null, locale));
	}

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

	// User Operation
	@Override
	public DataResult<BookingResponse> delete(long bookingId, Locale locale) {
		checkBookingIdExists(bookingId, locale);
		Booking booking = bookingDao.findById(bookingId).get();

		if (!booking.isDone()&& booking.getBookingDate().isAfter(LocalDate.now())) {
			bookingDao.deleteById(bookingId);

			return new SuccessDataResult<BookingResponse>(
					new BookingResponse(booking.getBookingId(), booking.getSystemUser().getName(),
							booking.getBookingDate(), booking.getBookingService().getServiceName(),
							booking.getBookingNote(), booking.isDone()),
					messageSource.getMessage("booking.delete.success", null, locale));
		}else {
			return new ErrorDataResult<BookingResponse>(new BookingResponse(booking.getBookingId(), booking.getSystemUser().getName(),
					booking.getBookingDate(), booking.getBookingService().getServiceName(),
					booking.getBookingNote(), booking.isDone()),
			messageSource.getMessage("booking.delete.error", null, locale));
		}
	}

	
	private LocalDate createBookingDate(int serviceDuration) {
		LocalDate bookingDate = LocalDate.now();
		int dailyWorkHours = 0;
		do {
			dailyWorkHours = serviceDuration;
			bookingDate = bookingDate.plusDays(1L);
			List<Booking> bookings = bookingDao.searchByBookingDate(bookingDate);
			for (Booking booking : bookings) {
				dailyWorkHours += booking.getBookingService().getServiceDuration();
			}
		} while (dailyWorkHours > 10);
		return bookingDate;
	}

	private void checkBookingIdExists(long bookingId, Locale locale) {
		if (!bookingDao.existsById(bookingId)) {
			throw new BusinessException(
					messageSource.getMessage("booking.checkbookingidexists.error", null, locale) + " " + bookingId);
		}

	}

}
