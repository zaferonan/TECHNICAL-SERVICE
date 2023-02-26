package com.turkcell.TechnicalService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long serviceId;
	
	@Column(length = 100)
	private String serviceName;
	
	private int desktop;
	
	private int laptop;
	
	private int mac;
	
	
	private int serviceDuration;


	public Service(long serviceId) {
		
		this.serviceId = serviceId;
	}
	
	
}
