package com.lip6.services;

import java.util.List;
import java.util.Optional;
import com.lip6.dtos.Contact;
import com.lip6.dtos.PhoneNumber;

public interface IContactService {
    public List<Contact> getAll();
    public Optional<Contact> get(Long id);
    public boolean save(Contact contact);
    public boolean delete(Long id);
    public void addPhoneNumber(Long id, PhoneNumber pn);
}
