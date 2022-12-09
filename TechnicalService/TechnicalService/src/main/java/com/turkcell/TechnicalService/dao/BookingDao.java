package com.turkcell.TechnicalService.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long>{

	boolean existsByBookingServiceServiceId(long bookingServiceId);

	boolean existsBySystemUserSystemUserId(long systemUserId);

	List<Booking> searchByBookingDate(LocalDate bookingDate);

	List<Booking> findBySystemUserNameContains(String userName);

	

}
