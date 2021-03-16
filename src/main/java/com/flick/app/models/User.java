package com.flick.app.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
@ToString
public class User {
    @Id
    @NonNull
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean isActive;
    private LocalDate addedOn;


}
