package com.lip6.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Group {
    
    private Long idGroup;
    private String name;
    private List<Contact> contacts;

}
