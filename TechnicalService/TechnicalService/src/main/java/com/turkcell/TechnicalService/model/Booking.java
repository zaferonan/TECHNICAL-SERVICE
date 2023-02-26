package com.turkcell.TechnicalService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	@ManyToOne
	@JoinColumn(name = "systemUser_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SystemUser systemUser;
	
	
	private LocalDate bookingDate;
	
	@Column(length = 300)
	private String bookingNote;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Service bookingService;
	
	
	private boolean isDone;
}
