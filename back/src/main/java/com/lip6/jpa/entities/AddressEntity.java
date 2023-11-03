package com.lip6.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name="addresses") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AddressEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zip;
    private String country;
    @OneToOne(mappedBy="address")
    private ContactEntity contact;

    public AddressEntity(String street, String city, String zip, String country) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

}
