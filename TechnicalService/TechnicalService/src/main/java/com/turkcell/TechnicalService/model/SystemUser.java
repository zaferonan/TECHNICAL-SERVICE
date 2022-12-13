package com.turkcell.TechnicalService.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SystemUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long systemUserId;

	@Column(length = 100)
	private String name;

	@Column(nullable = false)
	private String password;

	@Email
	@Column(unique = true, nullable = false, length = 200)
	private String mail;


	@ManyToMany
	@JoinColumn(name = "role_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Role> roles;

	public SystemUser(long systemUserId) {
		this.systemUserId = systemUserId;
	}

	
	
	

}
