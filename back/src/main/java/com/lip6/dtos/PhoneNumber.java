package com.lip6.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PhoneNumber {
    private Long id;
    private String phoneKind;
    private String phoneNumber;
}
