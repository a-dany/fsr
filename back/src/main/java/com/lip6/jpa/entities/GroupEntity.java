package com.lip6.jpa.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.checkerframework.common.aliasing.qual.Unique;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Group") 
@Table(name="groups")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class GroupEntity {

    public GroupEntity(String name) {
        this.name = name;
    }    

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroup;
    
    @Unique private String name;

    @ManyToMany( 
        cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER
    )
    @JoinTable(
        name="contact_groups", joinColumns = @JoinColumn(name = "idGroup"),
        inverseJoinColumns = @JoinColumn(name = "idContact")
    )
    private List<ContactEntity> contacts;

}
