package com.lip6.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Contact {

	private Long idContact;
	private String firstName;
	private String lastName;
	private String email;
	private Address address = null;
	private List<PhoneNumber> phoneNumbers = null;

	public Contact(Long id, String fn, String ln, String em) {
		this.idContact = id;
		this.firstName = fn; this.lastName = ln; this.email = em;
	}

}
