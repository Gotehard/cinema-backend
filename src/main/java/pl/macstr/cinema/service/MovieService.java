package pl.macstr.cinema.service;

import org.springframework.stereotype.Service;
import pl.macstr.cinema.dao.MovieRepository;
import pl.macstr.cinema.handlers.RecordNotFountException;
import pl.macstr.cinema.model.Movie;

import java.util.Optional;

@Service
public class MovieService {
    MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Iterable<Movie> findAll() {
        return repository.findAll();
    }

    public Movie findById(Integer id) {
        Optional<Movie> optionalMovie = repository.findById(id);
        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        }
        System.out.println("Movie not found");
        throw new RecordNotFountException("Movie not found");
    }

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
