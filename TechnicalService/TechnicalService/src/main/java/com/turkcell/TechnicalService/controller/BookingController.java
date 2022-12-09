package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.abstracts.BookingService;
import com.turkcell.TechnicalService.service.dtos.booking.requests.CreateBookingRequest;
import com.turkcell.TechnicalService.service.dtos.booking.responses.BookingResponse;
import com.turkcell.TechnicalService.service.dtos.booking.responses.ListBookingResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
	
	private final BookingService bookingService;

	//user operation
	@PostMapping("/createBooking")
	public DataResult<BookingResponse> createBooking(@Valid @RequestBody CreateBookingRequest createBookingRequest,Locale locale){
				
		return bookingService.createBooking(createBookingRequest,locale);
		
	}
	
	//admin operation
	@GetMapping("/getById")
	public DataResult<BookingResponse> getById(@RequestParam long bookingId,Locale locale){
		return bookingService.getById(bookingId, locale);
		
	}
	//admin operation
	@GetMapping("/getAll")
	public DataResult<List<ListBookingResponse>> getAll(@RequestParam Sort.Direction direction,Locale locale){
		return bookingService.getAll(direction, locale);
	}
	
	//user operation
	@DeleteMapping("/delete")
	public DataResult<BookingResponse> delete(@RequestParam long bookingId,Locale locale){
		return bookingService.delete(bookingId, locale);
		
	}
	//admin operation
	@GetMapping("/getByName")
	public DataResult<List<ListBookingResponse>> getByName(@RequestParam String userName,Locale locale){
		return bookingService.getByName(userName, locale);
	}
	//admin operation
	@PutMapping("/markBookingAsDone")
	public DataResult<BookingResponse> markBookingAsDone(@RequestParam long bookingId,Locale locale){
		return bookingService.markBookingAsDone(bookingId, locale);
	}
}