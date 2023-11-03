package com.lip6.jpa.daos;

import com.lip6._config.JpaUtil;
import com.lip6._config.Mapper;
import com.lip6.dtos.Contact;
import com.lip6.jpa.entities.AddressEntity;
import com.lip6.jpa.entities.ContactEntity;
import com.lip6.jpa.entities.PhoneNumberEntity;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOContact {

    public DAOContact() {}

    // Fonctionnel
    public boolean add(Contact contact) {
        boolean success=false; 
        try {

            ContactEntity ce = new ContactEntity(
                contact.getFirstName(), contact.getLastName(), contact.getEmail()
            );
            if (contact.getAddress() != null) {
                ce.addAddress(
                    Mapper.map(contact.getAddress(), AddressEntity.class)
                );
            }
            if(contact.getPhoneNumbers() != null && contact.getPhoneNumbers().size() > 0) {
                contact.getPhoneNumbers().forEach(
                    pn -> ce.addPhoneNumber( Mapper.map(pn, PhoneNumberEntity.class) )
                );
            }
            
            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(ce);
            tx.commit();
            em.close();

            success=true;

        } catch(Exception e) { e.printStackTrace(); }
        return success;
    }

    // Fonctionnel
    public ContactEntity get(Long id) {

        ContactEntity ce;
        String jpql = "SELECT c FROM Contact c LEFT JOIN FETCH c.address LEFT JOIN FETCH c.phoneNumbers WHERE c.idContact = :id"; 

        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            ce = em.createQuery(jpql, ContactEntity.class).setParameter("id", id).getSingleResult();
            tx.commit();
            em.close();

        } 
        catch (Exception e) { ce = null; e.printStackTrace(); }
        return ce;
    }

    // Fonctionnel
    public List<ContactEntity> getAll() {
        
        List<ContactEntity> lce;
        String jpql = "SELECT c FROM Contact c";

        try {
            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();
            
            tx.begin();
            lce = em.createQuery(jpql, ContactEntity.class).getResultList();
            tx.commit();
            em.close();
        } 
        catch(Exception e) { lce = Arrays.asList(); e.printStackTrace(); }
        return lce;
    }

    // Fonctionnel
    public boolean delete(Long id) {
        ContactEntity ce;
        boolean success = false;
        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            ce = em.merge(this.get(id)); // Important merge for synchronization
            if (ce != null){
                em.remove(ce);
            } 
            tx.commit();
            em.close();

            success = true;

        }
        catch (Exception e) { success = false; e.printStackTrace(); }
        return success;
    }

}