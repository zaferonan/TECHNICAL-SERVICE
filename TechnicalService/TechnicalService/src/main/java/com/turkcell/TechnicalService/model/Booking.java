package com.turkcell.TechnicalService.model;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
