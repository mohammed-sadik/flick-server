package com.flick.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Movie {
    @Id
    private Integer id;
    private String title;
    private String addedBy;
    private String ratingType;
    private String language;
    private String ratingStars;
    
}
