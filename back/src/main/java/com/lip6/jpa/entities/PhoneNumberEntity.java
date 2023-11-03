package com.lip6.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="PhoneNumber")
@Table(name="phone_numbers")
public class PhoneNumberEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String phoneKind;
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(name = "idContact")
    private ContactEntity contact;
    
    // Constructors
    public PhoneNumberEntity() {}
    public PhoneNumberEntity(String phoneKind, String phoneNumber) {
        this.phoneKind = phoneKind;
        this.phoneNumber = phoneNumber;
    }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setPhoneKind(String phoneKind) { this.phoneKind = phoneKind; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setContact(ContactEntity contact) { this.contact = contact; }
    
    // Getters
    public Long getId() { return id; }
    public String getPhoneKind() { return phoneKind; }
    public String getPhoneNumber() { return phoneNumber; }
    public ContactEntity getContact() { return contact; }

}
