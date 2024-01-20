package com.lip6.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="Contact") // Définit l'entité sur laquelle on travaille
@Table(name="contacts") // Cette ligne permet juste de renommer la table dans la base (contactS au lieu de contact)
@AllArgsConstructor @Getter @Setter
public class ContactEntity {

	private String firstName;
	private String lastName;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idAddress")
	private AddressEntity address = null;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contact", fetch = FetchType.EAGER)
	private List<PhoneNumberEntity> phoneNumbers = new ArrayList<>();

	// @ManyToMany() @JoinTable(name="contact_group_link")
	// private ContactGroup cgroup;

	// La stratégie de génération : 
	// identity : selon la table 
	// sequence : donne un id unique sur toutes les tables 
	// auto : hibernate choisit la meilleure stratégie de génération selon la bd
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	
	@ManyToMany(mappedBy = "contacts")
	private List<GroupEntity> groups;

	// Constructeurs
	public ContactEntity(){
	}
	public ContactEntity(String firstName, String lastName, String email, long idContact) {
		this(firstName, lastName, email);
		this.idContact = idContact;
	}
	public ContactEntity(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// Bi-Directional Relations
    public void addAddress(AddressEntity address) {
		this.setAddress(address);
		this.address.setContact(this);
    }
	public void addPhoneNumber(PhoneNumberEntity pn) {
		pn.setContact(this);
		this.phoneNumbers.add(pn);
	}
    public void removePhoneNumber(Long id) {
		phoneNumbers.removeIf(pn -> id.equals(pn.getId()));
    }

}
