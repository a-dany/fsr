package com.lip6.services;

import com.lip6._config.Mapper;
import com.lip6.dtos.Group;
import com.lip6.jpa.daos.DAOGroup;
import java.util.List;
import java.util.Optional;

public class GroupService {
    
    private DAOGroup dao;
    public GroupService() { this.dao = new DAOGroup(); }

    public boolean save(String name) {
        return this.dao.add(name);
    }

    public Optional<Group> get(Long id) {
        return Optional.ofNullable(
            this.dao.get(id)
        )
        .map(g -> Mapper.map(g, Group.class));
    }

    public boolean addContacts(Long id, List<Long> ids) {
        return this.dao.addContacts(id, ids);
    }

    public boolean removeContacts(Long id, List<Long> ids) {
        return this.dao.removeContacts(id, ids);
    }

    public boolean delete(Long id) {
        return this.dao.delete(id);
    }

    public boolean update(Long id, String name) {
        return this.dao.update(id, name);
    }

}
