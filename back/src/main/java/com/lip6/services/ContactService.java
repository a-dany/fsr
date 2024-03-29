package com.lip6.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.lip6._config.Mapper;
import com.lip6.dtos.Contact;
import com.lip6.dtos.PhoneNumber;
import com.lip6.jpa.daos.DAOContact;
import com.lip6.jpa.entities.ContactEntity;
import com.lip6.jpa.entities.PhoneNumberEntity;

@Service
public class ContactService implements IContactService {
    
    private DAOContact dao;
    public ContactService() { this.dao = new DAOContact(); }

    public List<Contact> getAll() {
        return this.dao.getAll().stream().map(e -> Mapper.map(e, Contact.class)).collect(Collectors.toList());
    }
    public Optional<Contact> get(Long id) {
        return Optional.ofNullable( this.dao.get(id) ).map( c -> Mapper.map(c, Contact.class) );
    }
    public boolean save(Contact contact) {
        return this.dao.add(contact);
    }
    public boolean delete(Long id) {
        return this.dao.delete(id);
    }

    public void addPhoneNumber(Long id, PhoneNumber pn) {
        pn.setId(null);
        this.dao.addPhoneNumber(id, Mapper.map(pn, PhoneNumberEntity.class));
    }
    public void removePhoneNumber(Long id, Long pnId) {
        this.dao.removePhoneNumber(id, pnId);
    }

    public boolean updateContact(Long id, Contact model) {
        return this.dao.updateContact(id, Mapper.map(model, ContactEntity.class));
    }

}
