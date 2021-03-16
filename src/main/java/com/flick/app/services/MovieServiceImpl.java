package com.flick.app.services;

import com.flick.app.models.Movie;
import com.flick.app.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.flick.app.mapper.MovieMapper.mapMovie;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Boolean saveMovie(Movie movie) {
        boolean status = false;
        if (!movieRepository.existsById(movie.getId())) {
            movieRepository.save(movie);
            status = true;
        } else {
            // throw MovieAlreadyExists Exception;
        }
        return status;
    }

    @Override
    public Boolean updateMovieById(Integer movieId, Movie movie) {
        boolean status = false;
        if (movieRepository.existsById(movieId)) {
            Optional<Movie> movieOptional = movieRepository.findById(movie.getId());
            if (movieOptional.isPresent()) {
                Movie movieObject = mapMovie(movie, movieOptional);
                movieRepository.save(movieObject);
                status = true;
            }
        } else {
            // throw MovieDoesNotExists Exception;
        }
        return status;
    }

    @Override
    public Movie getMovieById(Integer movieId) throws Exception {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        return movieOptional.orElseThrow(() -> new Exception("Movie does not exits by id:- " + movieId));
    }

    @Override
    public Boolean deleteMovieById(Integer movieId) {
        boolean status = false;
        if (movieRepository.existsById(movieId)) {
            movieRepository.delete(movieRepository.findById(movieId).get());
            status = true;
        } else {
            // throw MovieDoesNotExists Exception;
        }
        return status;
    }
}
