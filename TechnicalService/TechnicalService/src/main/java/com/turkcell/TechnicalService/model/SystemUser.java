package com.turkcell.TechnicalService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class SystemUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Size(max = 50)
	@Column(name = "username")
	private String username;
	
	@Size(max = 50)
	@Column(name = "user_password")
	private String userPassword;
	
	@Email
	@Size(max = 50)
	@Column(name = "user_mail")
	private String userMail;
	
	@Size(max = 100)
	@Column(name = "user_nameSurname")
	private String userNameSurname;
	
	@ManyToOne
	@JoinColumn(name = "user_role")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Role userRole;
	

}
