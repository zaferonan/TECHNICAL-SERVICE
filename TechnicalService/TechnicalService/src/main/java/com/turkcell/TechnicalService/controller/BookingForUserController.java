package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.abstracts.BookingForUserService;
import com.turkcell.TechnicalService.service.dtos.booking.requests.CreateBookingRequest;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;
import com.turkcell.TechnicalService.service.dtos.booking.responses.ListBookingResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingForUserController {

	private final BookingForUserService bookingForUserService;

	// user operation
	@PostMapping("/createBooking")
	public DataResult<BookingResponse> createBooking(@Valid @RequestBody CreateBookingRequest createBookingRequest,
			Locale locale) {

		return bookingForUserService.save(createBookingRequest, locale);

	}

	// user operation
	@DeleteMapping("/delete")
	public DataResult<BookingResponse> delete(@RequestParam long bookingId, Locale locale) {
		return bookingForUserService.delete(bookingId, locale);

	}

	@GetMapping("/getById")
	public DataResult<BookingResponse> getById(@RequestParam long bookingId, Locale locale) {
		return bookingForUserService.getById(bookingId, locale);

	}
	@GetMapping("/getAllByUser")
	public DataResult<List<ListBookingResponse>> getAllByUser(long systemUserId, Locale locale){
		return bookingForUserService.getAllByUser(systemUserId, locale);
	}

}