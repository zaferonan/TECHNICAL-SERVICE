package com.turkcell.TechnicalService.dao;

import com.turkcell.TechnicalService.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long>{

	boolean existsByBookingServiceServiceId(long bookingServiceId);

	boolean existsBySystemUserSystemUserId(long systemUserId);

	List<Booking> searchByBookingDate(LocalDate bookingDate);

	List<Booking> findBySystemUserNameContainsIgnoreCase(String userName);

	List<Booking> findAllBySystemUserSystemUserId(long systemUserId);

	

}
