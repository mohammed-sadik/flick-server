package com.flick.app.mapper;

import com.flick.app.models.Movie;

import java.util.Optional;

public class MovieMapper {

    public static Movie mapMovie(Movie movie, Optional<Movie> movieOptional) {
        Movie movieObject = movieOptional.get();
        movieObject.setTitle(movie.getTitle());
        movieObject.setRatingType(movie.getRatingType());
        movieObject.setLanguage(movie.getLanguage());
        movieObject.setRatingStars(movie.getRatingStars());
        movieObject.setAddedBy(movie.getAddedBy());
        return movieObject;
    }
}
