package com.masai.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.")
	private String firstName;
	
	@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only")
	private String mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address",joinColumns = @JoinColumn(name="customer_id",referencedColumnName = "customerId"))
	private Address address;
	
	@Email(message = "Please enter valid email address")
	private String email;
	
	@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits")
	private String password;

	public Customer(
			@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.") String firstName,
			@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.") String lastName,
			@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only") String mobileNumber,
			Address address, @Email(message = "Please enter valid email address") String email,
			@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	
	

	
	
	

	

	

	
}
