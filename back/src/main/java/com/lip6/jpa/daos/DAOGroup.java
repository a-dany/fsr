package com.lip6.jpa.daos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.lip6._config.JpaUtil;
import com.lip6.jpa.entities.ContactEntity;
import com.lip6.jpa.entities.GroupEntity;

// TODO: Rrfactor

public class DAOGroup {
    
    private DAOContact contacts;
    public DAOGroup() { this.contacts = new DAOContact(); }

    // Fonctionnel
    public boolean add(String name) {
        boolean success = false;
        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(
                new GroupEntity(name)
            );
            tx.commit();
            em.close();

            success = true;

        }
        catch (Exception e) { success = false; e.printStackTrace(); }
        return success;
    }

    // Fonctionnel
    public GroupEntity get(Long id) {
        GroupEntity ge;
        String jpql = "SELECT g FROM Group g WHERE g.idGroup = :id";
        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            ge = em.createQuery(jpql, GroupEntity.class).setParameter("id", id).getSingleResult();
            tx.commit();
            em.close();

        }
        catch (Exception e) { ge = null; e.printStackTrace(); }
        return ge;
    }

    // Fonctionnel
    public boolean addContacts(Long id, List<Long> ids) {
        boolean success = false;
        GroupEntity ge;
        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ge = this.get(id);
            if (ge != null && ids.size() > 0) {
                ids.forEach(i -> {
                    ContactEntity ce = em.merge(this.contacts.get(i));
                    if(ce != null)
                        ge.getContacts().add(ce);
                });
            }
            em.persist(
                em.merge(ge)
            );

            tx.commit();
            em.close();

            success = true;
        }
        catch (Exception e) { e.printStackTrace(); }
        return success;
    }

    // Fonctionnel
    public boolean removeContacts(Long id, List<Long> ids) {
        GroupEntity ge;
        boolean success = false;
        try {
            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            ge = this.get(id);
            if(ge != null) {
                ge.setContacts(
                    ge.getContacts().stream().filter(e -> !ids.contains(e.getIdContact())).collect(Collectors.toList())
                );
            }
            em.persist(
                em.merge(ge)
            );
            tx.commit();
            em.close();

            success = true;
        }
        catch (Exception e) { e.printStackTrace(); }
        return success;
    }

    // Fonctionnel
    public boolean delete(Long id) {
        GroupEntity ge;
        boolean success = false;
        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ge = em.merge( this.get(id) );
            if(ge != null) em.remove(ge);

            tx.commit();
            em.close();

            success = true;
        }
        catch (Exception e) { e.printStackTrace(); }
        return success;
    }

    // Non Fonctionnel
    public boolean update(Long id, String name) {
        boolean success = false;
        GroupEntity ge;
        try {

            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            ge = this.get(id);
            if(ge != null) {
                ge.setName(name);
                em.persist( em.merge(ge) );
            }

            tx.commit();
            em.close();
        }
        catch (Exception e) { e.printStackTrace(); }
        return success;
    }

    public List<GroupEntity> getAll() {

        List<GroupEntity> groups;
        String jpql = "SELECT g FROM Group g";

        try {
            EntityManager em = JpaUtil.getEmf().createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin ();
            groups = em.createQuery(jpql, GroupEntity.class).getResultList();
            tx.commit();
            em.close ();
        } 
        catch(Exception e) { groups = Arrays.asList(); e.printStackTrace(); }
        return groups;
    }

}
