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
        
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

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

        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

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
        
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
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

        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

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

    public boolean addPhoneNumber(Long id, PhoneNumberEntity pn) {
        boolean result = false;
        ContactEntity ce;

        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            ce = em.merge(this.get(id));
            if (ce != null){
                ce.addPhoneNumber(pn);
                em.persist(ce);
            } 
            tx.commit();
            em.close();

            result = true;
            
        } catch (Exception e) { result = false; e.printStackTrace(); }

        return result;
    }

    public boolean removePhoneNumber(Long id, Long pnId) {
        String jpql = "SELECT p FROM PhoneNumber p JOIN p.contact c WHERE p.id = :pnId AND c.idContact = :id"; 
        boolean result = false;
        ContactEntity ce; PhoneNumberEntity savedPn;
        
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            ce = this.get(id);
            if (ce != null) {
                ce.removePhoneNumber(pnId);
                savedPn = em.createQuery(jpql,  PhoneNumberEntity.class).setParameter("pnId", pnId).setParameter("id", id).getSingleResult();
                if (savedPn != null) {
                    savedPn = em.merge(savedPn);
                    savedPn.setContact(null);
                    em.remove(savedPn);
                }
                em.persist(em.merge(ce));
            }
            
            tx.commit();
            em.close ();

            result = true;
            
        } 
        catch (Exception e) { result = false; e.printStackTrace(); }

        return result;
    }

    public boolean updateContact(Long id, ContactEntity model) {

        boolean success = true;
        ContactEntity ce;
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            ce = this.get(id);

            if(ce == null) success = false;
            else {
                ce.setAddress(model.getAddress());
                ce.setFirstName(model.getFirstName());
                ce.setLastName(model.getLastName());
                ce.setEmail(model.getEmail());
                em.merge(ce);
                tx.commit();
            }

            tx.commit();

        }
        catch(Exception e) { success = false; }

        return success;

    }

}